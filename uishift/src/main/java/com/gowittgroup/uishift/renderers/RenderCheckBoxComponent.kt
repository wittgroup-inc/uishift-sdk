package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.components.UiShiftCheckBox
import com.gowittgroup.uishift.components.UiShiftText
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.models.components.CheckBoxComponent
import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.ValidationTrigger
import com.gowittgroup.uishift.screen.ComponentState
import com.gowittgroup.uishift.screen.ScreenIntent

@Composable
fun RenderCheckBoxComponent(
    state: ComponentState.CheckBoxState,
    component: CheckBoxComponent,
    onIntent: (ScreenIntent) -> Unit
) {
    RenderBaseProperties(component) { modifier ->
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
            UiShiftCheckBox(
                isEnabled = component.isEnabled,
                checked = state.isChecked,
                onCheckedChange = { isChecked ->
                    onIntent(ScreenIntent.UpdateCheckBox(component.id, isChecked))

                    if (component.validations.any { it.trigger == ValidationTrigger.ON_VALUE_CHANGE }) {
                        onIntent(
                            ScreenIntent.Validate(
                                field = Field(id = component.id, type = ComponentType.CHECKBOX),
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
