package com.gowittgroup.uishift.components

import UiShiftColorScheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.theme.ThemeConfig
import com.gowittgroup.uishift.theme.ThemeConfig.colorScheme

@Composable
fun UiShiftRadioButton(
    selected: Boolean,
    onClick: () -> Unit
) {
    RadioButton(
        selected = selected,
        onClick = onClick,
        colors = RadioButtonDefaults.colors(
            selectedColor = colorScheme.primaryButtonBackground,
            unselectedColor = colorScheme.secondaryLabelTextColor
        )
    )
}