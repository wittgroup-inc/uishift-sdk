package com.gowittgroup.uishift.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gowittgroup.uishift.ApiRepository
import com.gowittgroup.uishift.ApiResponse
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.domain.ConfigRepository
import com.gowittgroup.uishift.data.Result
import com.gowittgroup.uishift.models.Field
import com.gowittgroup.uishift.models.Request
import com.gowittgroup.uishift.models.Validation
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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
        fetchScreenConfig()
    }

    private fun fetchScreenConfig() {
        viewModelScope.launch {
            _screenConfigState.value = ScreenConfigState.Loading
            val result = configRepository.fetchScreenConfiguration()
            _screenConfigState.value = when (result) {
                is Result.Success -> ScreenConfigState.Success(result.data)
                is Result.Error -> ScreenConfigState.Error(
                    result.exception.message ?: "Unknown Error"
                )
            }
        }
    }

    // Retry fetching the configuration
    fun retryFetchingConfig() {
        fetchScreenConfig()
    }

    // Processing Intents
    fun processIntent(intent: ScreenIntent) {
        when (intent) {
            is ScreenIntent.UpdateTextField -> {
                _uiState.update { state ->
                    state.copy(
                        textFieldsState = state.textFieldsState.toMutableMap().apply {
                            put(intent.id, intent.value)
                        }
                    )
                }
            }

            is ScreenIntent.UpdateCheckBox -> {
                _uiState.update { state ->
                    state.copy(
                        checkBoxState = state.checkBoxState.toMutableMap().apply {
                            put(intent.id, intent.isChecked)
                        }
                    )
                }
            }

            is ScreenIntent.UpdateRadioButton -> {
                _uiState.update { state ->
                    state.copy(
                        radioButtonState = state.radioButtonState.toMutableMap().apply {
                            put(intent.id, intent.isChecked)
                        }
                    )
                }
            }

            is ScreenIntent.UpdateSwitch -> {
                _uiState.update { state ->
                    state.copy(
                        switchState = state.switchState.toMutableMap().apply {
                            put(intent.id, intent.isChecked)
                        }
                    )
                }
            }

            is ScreenIntent.UpdateSlider -> {
                _uiState.update { state ->
                    state.copy(
                        sliderState = state.sliderState.toMutableMap().apply {
                            put(intent.id, intent.value)
                        }
                    )
                }
            }

            is ScreenIntent.NavigateTo -> {
                navigateTo(intent.destination)
            }

            is ScreenIntent.ApiRequest -> executeApiRequest(intent.request)
            is ScreenIntent.ShowSuccess -> TODO()
            is ScreenIntent.ShowError -> TODO()
            is ScreenIntent.SubmitForm -> TODO()
            is ScreenIntent.Validate -> validateField(intent.field, intent.validation)
        }
    }

    private fun validateField(fieldId: Field, validation: Validation): Boolean {
        val value = getValue(fieldId)

        return when (validation) {
            is Validation.Base -> validateBase(value, validation)
            is Validation.Binary -> validateBoolean(value, validation)
            is Validation.Numeric -> validateNumeric(value, validation)
            is Validation.Selection -> validateSelection(value, validation)
            is Validation.Text -> validateText(value, validation)
            Validation.None -> true // No validation needed
        }
    }

    private fun validateBase(value: Any?, validation: Validation.Base): Boolean {
        return !validation.required || value != null
    }

    private fun validateText(value: Any?, validation: Validation.Text): Boolean {
        if (value !is String) return false
        return (!validation.required || value.isNotEmpty()) && // Check if required
                (validation.minLength == null || value.length >= validation.minLength) && // Min length
                (validation.maxLength == null || value.length <= validation.maxLength) && // Max length
                (validation.regex == null || Regex(validation.regex).matches(value)) // Regex match
    }

    private fun validateBoolean(value: Any?, validation: Validation.Binary): Boolean {
        if (value !is Boolean) return false
        return !validation.required || value // Return true if required and checked
    }

    private fun validateNumeric(value: Any?, validation: Validation.Numeric): Boolean {
        if (value !is Float) return false
        return (!validation.required || value != 0f) && // Check if required
                (validation.minValue == null || value >= validation.minValue) && // Min value
                (validation.maxValue == null || value <= validation.maxValue) // Max value
    }

    private fun validateSelection(value: Any?, validation: Validation.Selection): Boolean {
        // Assuming value is of type String and represents the selected option
        return !validation.required || value != null
    }

    private fun getValue(field: Field): Any? {
        return when (field.type) {
            ComponentType.TEXT -> uiState.value.textFieldsState[field.id]
            ComponentType.CHECKBOX -> uiState.value.checkBoxState[field.id]
            ComponentType.SWITCH -> uiState.value.switchState[field.id]
            ComponentType.RADIO_BUTTON -> uiState.value.radioButtonState[field.id]
            ComponentType.SLIDER -> uiState.value.sliderState[field.id]
            else -> {}
        }
    }

    private fun executeApiRequest(request: Request) {
        viewModelScope.launch {
            try {
                // Perform the API request and get the ApiResponse
                val response: ApiResponse<Any> = apiRepository.performRequest(request)

                // Check if the response indicates success
                if (response.success) {
                    // Handle successful response, update the live data with the response data
                     response.data // You might want to cast it to the expected type
                } else {
                    // Handle error message and code
                    response.message ?: "An error occurred: ${response.errorCode ?: "Unknown error"}"
                }
            } catch (e: Exception) {
                // Handle network or unexpected errors
                 e.message ?: "An unknown error occurred"
            }
        }
    }

    private fun submitForm(state: ScreenState) {
        // Handle form submission
    }

    private fun navigateTo(destination: String) {
        viewModelScope.launch {
            _navigationEventChannel.send(NavigationEvent.NavigateTo(destination))
        }
    }
}

sealed class NavigationEvent {
    data class NavigateTo(val destination: String) : NavigationEvent()
    object NavigateUp : NavigationEvent()
}