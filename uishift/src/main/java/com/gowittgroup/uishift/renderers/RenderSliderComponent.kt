package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gowittgroup.uishift.components.UiShiftSlider
import com.gowittgroup.uishift.components.UiShiftText
import com.gowittgroup.uishift.constants.ComponentType
import com.gowittgroup.uishift.models.components.SliderComponent
import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.ValidationTrigger
import com.gowittgroup.uishift.screen.ComponentState
import com.gowittgroup.uishift.screen.ScreenIntent

@Composable
fun RenderSliderComponent(
    state: ComponentState.SliderState,
    component: SliderComponent,
    onIntent: (ScreenIntent) -> Unit
) {
    RenderBaseProperties(component) { modifier ->
        Column(modifier = modifier) {
            UiShiftSlider(
                value = state.value,
                isEnabled = component.isEnabled,
                onValueChange = { newValue ->
                    onIntent(ScreenIntent.UpdateSlider(component.id, newValue))

                    if (component.validations.any { it.trigger == ValidationTrigger.ON_VALUE_CHANGE }) {
                        onIntent(
                            ScreenIntent.Validate(
                                field = Field(id = component.id, type = ComponentType.SLIDER),
                                validations = component.validations
                            )
                        )
                    }
                },
                valueRange = component.min..component.max,
                modifier = Modifier.fillMaxWidth()
            )
            UiShiftText(text = "Selected value: ${state.value}")
        }
    }
}
