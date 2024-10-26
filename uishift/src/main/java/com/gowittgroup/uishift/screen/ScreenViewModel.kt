package com.gowittgroup.uishift.screen

import android.util.Log
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
                        Log.e(TAG, "Error fetching screen configuration: ${result.exception.message}")
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
            is ScreenIntent.UpdateTextField -> {
                Log.d(TAG, "Updating text field: ${intent.id}")
                _uiState.update { state ->
                    state.copy(
                        textFieldsState = state.textFieldsState.toMutableMap().apply {
                            put(intent.id, intent.value)
                        }
                    )
                }
            }

            is ScreenIntent.UpdateCheckBox -> {
                Log.d(TAG, "Updating checkbox: ${intent.id}")
                _uiState.update { state ->
                    state.copy(
                        checkBoxState = state.checkBoxState.toMutableMap().apply {
                            put(intent.id, intent.isChecked)
                        }
                    )
                }
            }

            is ScreenIntent.UpdateRadioButton -> {
                Log.d(TAG, "Updating radio button: ${intent.id}")
                _uiState.update { state ->
                    state.copy(
                        radioButtonState = state.radioButtonState.toMutableMap().apply {
                            put(intent.id, intent.isChecked)
                        }
                    )
                }
            }

            is ScreenIntent.UpdateSwitch -> {
                Log.d(TAG, "Updating switch: ${intent.id}")
                _uiState.update { state ->
                    state.copy(
                        switchState = state.switchState.toMutableMap().apply {
                            put(intent.id, intent.isChecked)
                        }
                    )
                }
            }

            is ScreenIntent.UpdateSlider -> {
                Log.d(TAG, "Updating slider: ${intent.id}")
                _uiState.update { state ->
                    state.copy(
                        sliderState = state.sliderState.toMutableMap().apply {
                            put(intent.id, intent.value)
                        }
                    )
                }
            }

            is ScreenIntent.NavigateTo -> {
                Log.d(TAG, "Navigating to: ${intent.destination}")
                navigateTo(intent.destination)
            }

            is ScreenIntent.ApiRequest -> {
                Log.d(TAG, "Executing API request for: ${intent.request}")
                executeApiRequest(intent.request)
            }

            is ScreenIntent.ShowSuccess -> {
                Log.d(TAG, "Showing success message: ${intent.message}")
            }

            is ScreenIntent.ShowError -> {
                Log.e(TAG, "Showing error message: ${intent.field}")
            }

            is ScreenIntent.SubmitForm -> {
                Log.d(TAG, "Submitting form")
                submitForm(uiState.value)
            }

            is ScreenIntent.Validate -> {
                Log.d(TAG, "Validating field: ${intent.field}")
                validateField(intent.field, intent.validation)
            }
        }
    }

    private fun validateField(fieldId: Field, validation: Validation): Boolean {
        val value = getValue(fieldId)
        val isValid = when (validation) {
            is Validation.Base -> validateBase(value, validation)
            is Validation.Text -> validateText(value, validation)
            is Validation.Binary -> validateBoolean(value, validation)
            is Validation.Numeric -> validateNumeric(value, validation)
            is Validation.Selection -> validateSelection(value, validation)
            is Validation.None -> true
        }
        Log.d(TAG, "Validation result for field ${fieldId.id}: $isValid")
        return isValid
    }

    private fun validateBase(value: Any?, validation: Validation.Base): Boolean {
        return !validation.required || value != null
    }

    private fun validateText(value: Any?, validation: Validation.Text): Boolean {
        if (value !is String) return false
        return (!validation.required || value.isNotEmpty()) &&
                (validation.minLength == null || value.length >= validation.minLength) &&
                (validation.maxLength == null || value.length <= validation.maxLength) &&
                (validation.regex == null || Regex(validation.regex).matches(value))
    }

    private fun validateBoolean(value: Any?, validation: Validation.Binary): Boolean {
        if (value !is Boolean) return false
        return !validation.required || value
    }

    private fun validateNumeric(value: Any?, validation: Validation.Numeric): Boolean {
        if (value !is Float) return false
        return (!validation.required || value != 0f) &&
                (validation.minValue == null || value >= validation.minValue) &&
                (validation.maxValue == null || value <= validation.maxValue)
    }

    private fun validateSelection(value: Any?, validation: Validation.Selection): Boolean {
        return !validation.required || value != null
    }

    private fun getValue(field: Field): Any? {
        return when (field.type) {
            ComponentType.TEXT -> uiState.value.textFieldsState[field.id]
            ComponentType.CHECKBOX -> uiState.value.checkBoxState[field.id]
            ComponentType.SWITCH -> uiState.value.switchState[field.id]
            ComponentType.RADIO_BUTTON -> uiState.value.radioButtonState[field.id]
            ComponentType.SLIDER -> uiState.value.sliderState[field.id]
            else -> null.also { Log.e(TAG, "Unknown field type: ${field.type}") }
        }
    }

    private fun executeApiRequest(request: Request) {
        viewModelScope.launch {
            try {
                val response: ApiResponse<Any> = apiRepository.performRequest(request)
                if (response.success) {
                    Log.d(TAG, "API request successful: ${response.data}")
                    _navigationEventChannel.send(NavigationEvent.ShowMessage("Success!"))
                } else {
                    Log.e(TAG, "API request failed: ${response.message ?: "Unknown error"}")
                    _navigationEventChannel.send(NavigationEvent.ShowMessage(response.message ?: "Request Failed"))
                }
            } catch (e: Exception) {
                Log.e(TAG, "API request error: ${e.message}")
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
            Log.d(TAG, "Navigating to: $destination")
            _navigationEventChannel.send(NavigationEvent.NavigateTo(destination))
        }
    }
}

sealed class NavigationEvent {
    data class NavigateTo(val destination: String) : NavigationEvent()
    data class ShowMessage(val message: String) : NavigationEvent()
    data object NavigateUp : NavigationEvent()
}
