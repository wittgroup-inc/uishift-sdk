package com.gowittgroup.uishift.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gowittgroup.uishift.data.ApiRepository
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.data.Result
import com.gowittgroup.uishift.domain.ConfigRepository
import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.Request
import com.gowittgroup.uishift.models.properties.Validation
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

private const val TAG = "ScreenViewModel"

class ScreenViewModel(
    private val configRepository: ConfigRepository,
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ScreenState())
    val uiState: StateFlow<ScreenState> = _uiState.asStateFlow()

    private val _screenConfigState = MutableStateFlow<ScreenConfigState>(ScreenConfigState.Loading)
    val screenConfigState: StateFlow<ScreenConfigState> = _screenConfigState

    private val _navigationEventChannel = Channel<NavigationEvent>()
    val navigationEvents = _navigationEventChannel.receiveAsFlow()

    init {
        Log.d(TAG, "Fetching initial screen configuration")
        fetchScreenConfig()
    }

    private fun fetchScreenConfig() {
        viewModelScope.launch {
            _screenConfigState.value = ScreenConfigState.Loading
            try {
                val result = configRepository.fetchScreenConfiguration()
                _screenConfigState.value = when (result) {
                    is Result.Success -> {
                        Log.d(TAG, "Screen configuration fetched successfully")
                        ScreenConfigState.Success(result.data)
                    }

                    is Result.Error -> {
                        Log.e(
                            TAG,
                            "Error fetching screen configuration: ${result.exception.message}"
                        )
                        ScreenConfigState.Error(result.exception.message ?: "Unknown Error")
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception occurred during fetchScreenConfig: ${e.message}")
                _screenConfigState.value = ScreenConfigState.Error(e.message ?: "Unknown Exception")
            }
        }
    }

    fun retryFetchingConfig() {
        Log.d(TAG, "Retrying fetching screen configuration")
        fetchScreenConfig()
    }

    fun processIntent(intent: ScreenIntent) {
        Log.d(TAG, "Processing intent: $intent")
        when (intent) {
            is ScreenIntent.UpdateTextField -> updateComponentState(
                intent.id,
                intent.value,
                ComponentType.TEXT_FIELD
            )

            is ScreenIntent.UpdateCheckBox -> updateComponentState(
                intent.id,
                intent.isChecked,
                ComponentType.CHECKBOX
            )

            is ScreenIntent.UpdateRadioButton -> updateComponentState(
                intent.id,
                intent.isChecked,
                ComponentType.RADIO_BUTTON
            )

            is ScreenIntent.UpdateSwitch -> updateComponentState(
                intent.id,
                intent.isChecked,
                ComponentType.SWITCH
            )

            is ScreenIntent.UpdateSlider -> updateComponentState(
                intent.id,
                intent.value,
                ComponentType.SLIDER
            )

            is ScreenIntent.NavigateTo -> navigateTo(intent.destination)
            is ScreenIntent.ApiRequest -> executeApiRequest(intent.request)
            is ScreenIntent.ShowSuccess -> Log.d(TAG, "Showing success message: ${intent.message}")
            is ScreenIntent.ShowError -> Log.e(TAG, "Showing error message: ${intent.field}")
            is ScreenIntent.SubmitForm -> submitForm(uiState.value)
            is ScreenIntent.Validate -> validateField(intent.field, intent.validation)
        }
    }

    private fun <T> updateComponentState(
        id: String,
        value: T,
        type: String,
        isValid: Boolean = true,
        errorMsg: String = ""
    ) {
        _uiState.update { state ->
            when (type) {
                ComponentType.TEXT_FIELD -> state.copy(
                    textFieldsState = state.textFieldsState.toMutableMap().apply {
                        put(id, ComponentState.TextFieldState(value as String, isValid, errorMsg))
                    }
                )
                ComponentType.CHECKBOX -> state.copy(
                    checkBoxState = state.checkBoxState.toMutableMap().apply {
                        put(id, ComponentState.CheckBoxState(value as Boolean, isValid, errorMsg))
                    }
                )
                ComponentType.RADIO_BUTTON -> state.copy(
                    radioButtonState = state.radioButtonState.toMutableMap().apply {
                        put(id, ComponentState.RadioButtonState(value as Boolean, isValid, errorMsg))
                    }
                )
                ComponentType.SWITCH -> state.copy(
                    switchState = state.switchState.toMutableMap().apply {
                        put(id, ComponentState.SwitchState(value as Boolean, isValid, errorMsg))
                    }
                )
                ComponentType.SLIDER -> state.copy(
                    sliderState = state.sliderState.toMutableMap().apply {
                        put(id, ComponentState.SliderState(value as Float, isValid, errorMsg))
                    }
                )
                else -> state
            }
        }
    }

    private fun validateField(field: Field, validation: Validation): Boolean {
        val componentState = getComponentState(field) ?: run {
            Log.e(TAG, "Component state not found for field ${field.id}. Cannot validate.")
            return false // Return false if the component state is not found
        }

        val isValid = when (validation) {
            is Validation.Text -> validateText(field, getValue(componentState), validation)
            is Validation.Binary -> validateBoolean(field, getValue(componentState), validation)
            is Validation.Numeric -> validateNumeric(field, getValue(componentState), validation)
            is Validation.Selection -> validateSelection(field, getValue(componentState), validation)
            is Validation.None -> true // No validation required
        }

        Log.d(TAG, "Validation result for field ${field.id}: $isValid")
        if (!isValid) {
            Log.e(TAG, "Field ${field.id} is invalid with current value: $componentState")
        }

        return isValid
    }

    private fun <T> getValue(componentState: ComponentState): T {
        return when (componentState) {
            is ComponentState.CheckBoxState -> componentState.isChecked as T
            is ComponentState.RadioButtonState -> componentState.selected as T
            is ComponentState.SliderState -> componentState.value as T
            is ComponentState.SwitchState -> componentState.isChecked as T
            is ComponentState.TextFieldState -> componentState.value as T
        }
    }

    private fun getComponentState(field: Field): ComponentState? {
        return when (field.type) {
            ComponentType.TEXT -> uiState.value.textFieldsState[field.id]
            ComponentType.CHECKBOX -> uiState.value.checkBoxState[field.id]
            ComponentType.SWITCH -> uiState.value.switchState[field.id]
            ComponentType.RADIO_BUTTON -> uiState.value.radioButtonState[field.id]
            ComponentType.SLIDER -> uiState.value.sliderState[field.id]
            else -> null
        }
    }

    private fun validateText(field: Field, value: String?, validation: Validation.Text): Boolean {
        if (validation.required && value.isNullOrEmpty()) {
            updateComponentState(field.id, value ?: "", field.type, false, "Text is required")
            return false
        }

        value?.let {
            if (validation.minLength != null && it.length < validation.minLength) {
                updateComponentState(field.id, it, field.type, false, "Minimum length is ${validation.minLength}")
                return false
            }

            if (validation.maxLength != null && it.length > validation.maxLength) {
                updateComponentState(field.id, it, field.type, false, "Maximum length is ${validation.maxLength}")
                return false
            }

            if (validation.regex != null && !Regex(validation.regex).matches(it)) {
                updateComponentState(field.id, it, field.type, false, "Value does not match the required pattern")
                return false
            }
        }

        updateComponentState(field.id, value ?: "", field.type, true)
        return true
    }

    private fun validateBoolean(field: Field, value: Boolean?, validation: Validation.Binary): Boolean {
        if (validation.required && value != true) {
            updateComponentState(field.id, value ?: false, field.type, false, "Boolean field is required")
            return false
        }
        updateComponentState(field.id, value ?: false, field.type, true)
        return true
    }

    private fun validateNumeric(field: Field, value: Float?, validation: Validation.Numeric): Boolean {
        if (validation.required && value == null) {
            updateComponentState(field.id, value ?: 0f, field.type, false, "Numeric field is required")
            return false
        }

        value?.let {
            if (validation.minValue != null && it < validation.minValue) {
                updateComponentState(field.id, it, field.type, false, "Value must be at least ${validation.minValue}")
                return false
            }

            if (validation.maxValue != null && it > validation.maxValue) {
                updateComponentState(field.id, it, field.type, false, "Value must not exceed ${validation.maxValue}")
                return false
            }
        }

        updateComponentState(field.id, value ?: 0f, field.type, true)
        return true
    }

    private fun validateSelection(field: Field, value: Boolean?, validation: Validation.Selection): Boolean {
        if (validation.required && value != true) {
            updateComponentState(field.id, value ?: false, field.type, false, "Selection is required")
            return false
        }
        updateComponentState(field.id, value ?: false, field.type, true)
        return true
    }


    private fun executeApiRequest(request: Request) {
        viewModelScope.launch {
            try {
                val response = apiRepository.performRequest(request)
                if (response.success) {
                    _navigationEventChannel.send(NavigationEvent.ShowMessage("Success!"))
                } else {
                    _navigationEventChannel.send(
                        NavigationEvent.ShowMessage(
                            response.message ?: "Request Failed"
                        )
                    )
                }
            } catch (e: Exception) {
                _navigationEventChannel.send(NavigationEvent.ShowMessage("Request Error"))
            }
        }
    }

    private fun submitForm(state: ScreenState) {
        Log.d(TAG, "Form submission initiated with state: $state")
        // Handle form submission logic
    }

    private fun navigateTo(destination: String) {
        viewModelScope.launch {
            _navigationEventChannel.send(NavigationEvent.NavigateTo(destination))
        }
    }
}

sealed class NavigationEvent {
    data class NavigateTo(val destination: String) : NavigationEvent()
    data class ShowMessage(val message: String) : NavigationEvent()
    object NavigateUp : NavigationEvent()
}
