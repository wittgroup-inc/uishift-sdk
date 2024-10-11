package com.gowittgroup.uishift.components

import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gowittgroup.uishift.theme.ThemeConfig.colorScheme

@Composable
fun UiShiftSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    isEnabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = valueRange,
        enabled = isEnabled,
        colors = SliderDefaults.colors(
            activeTrackColor = colorScheme.sliderTrackColor,
            inactiveTrackColor = colorScheme.sliderDisabledTrackColor,
            thumbColor = colorScheme.sliderThumbColor,
            disabledThumbColor = colorScheme.sliderDisabledThumbColor,
        ),
        modifier = modifier
    )
}

@Preview
@Composable
private fun UiShiftSliderPrev() {
    Slider(value = 0.3f, onValueChange = {})
}
