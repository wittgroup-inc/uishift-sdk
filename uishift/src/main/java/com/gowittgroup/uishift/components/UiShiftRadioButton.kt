package com.gowittgroup.uishift.components

import UiShiftColorScheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.theme.ThemeConfig

@Composable
fun UiShiftRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    colorScheme: UiShiftColorScheme = ThemeConfig.colorScheme // Accept the color scheme as a parameter
) {
    RadioButton(
        selected = selected,
        onClick = onClick,
        colors = RadioButtonDefaults.colors(
            selectedColor = colorScheme.primaryButtonBackground, // Selected color from color scheme
            unselectedColor = colorScheme.secondaryLabelTextColor // Unselected color from color scheme
        )
    )
}