package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.gowittgroup.uishift.screen.ScreenState
import com.gowittgroup.uishift.components.UiShiftSlider
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderSliderComponent(
    screenState: ScreenState,
    component: UIComponent.SliderComponent,
    onValueChange: (Float) -> Unit
) {
    var sliderValue by remember {
        mutableFloatStateOf(
            screenState.sliderState[component.id] ?: component.initialValue
        )
    }

    sliderValue = screenState.sliderState[component.id] ?: component.initialValue

    Column {
        UiShiftSlider(
            value = sliderValue,
            isEnabled = component.isEnabled,
            onValueChange = onValueChange,
            valueRange = component.min..component.max,
            modifier = Modifier.fillMaxWidth()
        )
        Text("Selected value: $sliderValue")
    }
}