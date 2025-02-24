package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.components.UiShiftRadioButton
import com.gowittgroup.uishift.components.UiShiftText
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.models.components.RadioButtonComponent
import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.ValidationTrigger
import com.gowittgroup.uishift.screen.ComponentState
import com.gowittgroup.uishift.screen.ScreenIntent

@Composable
fun RenderRadioButtonComponent(
    state: ComponentState.RadioButtonState,
    component: RadioButtonComponent,
    onIntent: (ScreenIntent) -> Unit
) {
    RenderBaseProperties(component) { modifier ->
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
            UiShiftRadioButton(
                isEnabled = component.isEnabled,
                selected = state.selected,
                onClick = {
                    onIntent(ScreenIntent.UpdateRadioButton(component.id, !state.selected))

                    if (component.validations.any { it.trigger == ValidationTrigger.ON_VALUE_CHANGE }) {
                        onIntent(
                            ScreenIntent.Validate(
                                field = Field(id = component.id, type = ComponentType.RADIO_BUTTON),
                                validations = component.validations
                            )
                        )
                    }
                }
            )
            UiShiftText(text = component.label)
        }
    }
}
