package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.components.UiShiftSwitch
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.models.components.SwitchComponent
import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.ValidationTrigger
import com.gowittgroup.uishift.screen.ComponentState
import com.gowittgroup.uishift.screen.ScreenIntent

@Composable
fun RenderSwitchComponent(
    state: ComponentState.SwitchState,
    component: SwitchComponent,
    onIntent: (ScreenIntent) -> Unit
) {
    RenderBaseProperties(component) { modifier ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(component.label)
            UiShiftSwitch(
                isEnabled = component.isEnabled,
                checked = state.isChecked,
                onCheckedChange = { isChecked ->
                    onIntent(ScreenIntent.UpdateSwitch(component.id, isChecked))

                    if (component.validations.any { it.trigger == ValidationTrigger.ON_VALUE_CHANGE }) {
                        ScreenIntent.Validate(
                            field = Field(id = component.id, type = ComponentType.SWITCH),
                            validations = component.validations
                        )
                    }
                }
            )
        }
    }
}

