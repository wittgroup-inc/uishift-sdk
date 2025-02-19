package com.gowittgroup.uishift.renderers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gowittgroup.uishift.components.UiShiftTextField
import com.gowittgroup.uishift.models.components.TextFieldComponent
import com.gowittgroup.uishift.screen.ComponentState

@Composable
fun RenderTextFieldComponent(
    state: ComponentState.TextFieldState,
    component: TextFieldComponent,
    onValueChange: (String) -> Unit
) {
    var text by remember {
        mutableStateOf(
            component.initialValue
        )
    }

    text = state.value

    RenderBaseProperties(component) { modifier ->
        UiShiftTextField(
            isError = state.isValid,
            value = text,
            isEnabled = component.isEnabled,
            readOnly = component.readOnly,
            onValueChange = onValueChange,
            label = component.label,
            hint = component.hint,
            modifier = modifier
        )
    }

}
