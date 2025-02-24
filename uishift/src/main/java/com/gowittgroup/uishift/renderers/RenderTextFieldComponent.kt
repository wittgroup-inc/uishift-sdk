package com.gowittgroup.uishift.renderers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import com.gowittgroup.uishift.components.UiShiftTextField
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.models.components.TextFieldComponent
import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.ValidationTrigger
import com.gowittgroup.uishift.models.properties.toComposeTransformation
import com.gowittgroup.uishift.screen.ComponentState
import com.gowittgroup.uishift.screen.ScreenIntent

@Composable
fun RenderTextFieldComponent(
    state: ComponentState.TextFieldState,
    component: TextFieldComponent,
    onIntent: (ScreenIntent) -> Unit
) {
    var text by remember { mutableStateOf(component.initialValue) }
    val focusRequester = remember { FocusRequester() }

    var isFocused by remember { mutableStateOf(false) }
    text = state.value

    RenderBaseProperties(component) { modifier ->
        UiShiftTextField(
            isError = !state.isValid,
            value = text,
            isEnabled = component.isEnabled,
            readOnly = component.readOnly,
            onValueChange = { newText ->
                onIntent(ScreenIntent.UpdateTextField(component.id, newText))
            },
            label = component.label,
            hint = component.hint,
            modifier = modifier
                .focusRequester(focusRequester)
                .onFocusChanged { focusState ->
                    if (!focusState.isFocused && component.validations.any { it.trigger == ValidationTrigger.ON_BLUR }) {
                        ScreenIntent.Validate(
                            field = Field(id = component.id, type = ComponentType.TEXT_FIELD),
                            validations = component.validations
                        )
                    }
                    isFocused = focusState.isFocused
                },
            visualTransformation = component.visualTransformation.toComposeTransformation()
        )
    }
}

