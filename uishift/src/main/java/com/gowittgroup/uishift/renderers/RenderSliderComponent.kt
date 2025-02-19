package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.gowittgroup.uishift.components.UiShiftSlider
import com.gowittgroup.uishift.components.UiShiftText
import com.gowittgroup.uishift.models.components.SliderComponent
import com.gowittgroup.uishift.screen.ComponentState

@Composable
fun RenderSliderComponent(
    state: ComponentState.SliderState,
    component: SliderComponent,
    onValueChange: (Float) -> Unit
) {
    var sliderValue by remember {
        mutableFloatStateOf(
            state.value
        )
    }

    sliderValue = state.value

    RenderBaseProperties(component) { modifier ->
        Column(modifier = modifier) {
            UiShiftSlider(
                value = sliderValue,
                isEnabled = component.isEnabled,
                onValueChange = onValueChange,
                valueRange = component.min..component.max,
                modifier = Modifier.fillMaxWidth()
            )
            UiShiftText(text = "Selected value: $sliderValue")
        }

    }

}