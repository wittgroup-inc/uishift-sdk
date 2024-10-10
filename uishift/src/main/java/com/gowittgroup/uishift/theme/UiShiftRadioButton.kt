package com.gowittgroup.uishift.theme

import UiShiftColorScheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable


@Composable
fun MaterialThemeRadioButton(
    selected: Boolean,
    onClick: () -> Unit
) {
    RadioButton(
        selected = selected,
        onClick = onClick
    )
}

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