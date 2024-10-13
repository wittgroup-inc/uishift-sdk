package com.gowittgroup.uishift.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gowittgroup.uishift.domain.ConfigRepository
import com.gowittgroup.uishift.data.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ScreenViewModel(
    private val configRepository: ConfigRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ScreenState())
    val uiState: StateFlow<ScreenState> = _uiState.asStateFlow()

    private val _screenConfigState = MutableStateFlow<ScreenConfigState>(ScreenConfigState.Loading)
    val screenConfigState: StateFlow<ScreenConfigState> = _screenConfigState

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
            ScreenIntent.SubmitForm -> {
                submitForm(_uiState.value)
            }
            is ScreenIntent.NavigateTo -> {
                navigateTo(intent.destination)
            }
        }
    }

    private fun submitForm(state: ScreenState) {
        // Handle form submission
    }

    private fun navigateTo(destination: String) {
        // Handle navigation
    }
}