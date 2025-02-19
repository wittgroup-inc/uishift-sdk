package com.gowittgroup.uishift.screen

import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.models.properties.Field

sealed class ComponentState {
    data class TextFieldState(
        val value: String = "",
        val isValid: Boolean = true,
        val errorMessage: String? = null
    ) : ComponentState()

    data class CheckBoxState(
        val isChecked: Boolean = false,
        val isValid: Boolean = true,
        val errorMessage: String? = null
    ) : ComponentState()

    data class SwitchState(
        val isChecked: Boolean = false,
        val isValid: Boolean = true,
        val errorMessage: String? = null
    ) : ComponentState()

    data class RadioButtonState(
        val selected: Boolean = false,
        val isValid: Boolean = true,
        val errorMessage: String? = null
    ) : ComponentState()

    data class SliderState(
        val value: Float = 0.0f,
        val isValid: Boolean = true,
        val errorMessage: String? = null
    ) : ComponentState()
}

data class ScreenState(
    val textFieldsState: Map<String, ComponentState.TextFieldState> = emptyMap(),
    val checkBoxState: Map<String, ComponentState.CheckBoxState> = emptyMap(),
    val radioButtonState: Map<String, ComponentState.RadioButtonState> = emptyMap(),
    val switchState: Map<String, ComponentState.SwitchState> = emptyMap(),
    val sliderState: Map<String, ComponentState.SliderState> = emptyMap(),
    val isLoading: Boolean = false,
    val error: String? = null
)

fun getComponentState(field: Field, state: ScreenState): ComponentState? {
    return when (field.type) {
        ComponentType.TEXT -> state.textFieldsState[field.id]
        ComponentType.CHECKBOX -> state.checkBoxState[field.id]
        ComponentType.SWITCH -> state.switchState[field.id]
        ComponentType.RADIO_BUTTON -> state.radioButtonState[field.id]
        ComponentType.SLIDER -> state.sliderState[field.id]
        else -> null
    }
}