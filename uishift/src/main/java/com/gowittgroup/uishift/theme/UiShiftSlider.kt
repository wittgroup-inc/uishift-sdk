package com.gowittgroup.uishift.theme

import UiShiftColorScheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MaterialThemeSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = valueRange,
        modifier = modifier
    )
}


@Composable
fun UiShiftSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    colorScheme: UiShiftColorScheme = ThemeConfig.colorScheme // Accept the color scheme as a parameter
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = valueRange,
        colors = SliderDefaults.colors(
            activeTrackColor = colorScheme.sliderTrackColor, // Active track color from color scheme
            inactiveTrackColor = colorScheme.sliderDisabledTrackColor, // Inactive track color from color scheme
            thumbColor = colorScheme.sliderThumbColor // Thumb color from color scheme
        ),
        modifier = modifier
    )
}
