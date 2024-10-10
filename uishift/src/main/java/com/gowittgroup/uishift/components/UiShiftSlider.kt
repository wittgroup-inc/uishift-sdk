package com.gowittgroup.uishift.components

import UiShiftColorScheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gowittgroup.uishift.theme.ThemeConfig
import com.gowittgroup.uishift.theme.ThemeConfig.colorScheme

@Composable
fun UiShiftSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = valueRange,
        colors = SliderDefaults.colors(
            activeTrackColor = colorScheme.sliderTrackColor,
            inactiveTrackColor = colorScheme.sliderDisabledTrackColor,
            thumbColor = colorScheme.sliderThumbColor
        ),
        modifier = modifier
    )
}
