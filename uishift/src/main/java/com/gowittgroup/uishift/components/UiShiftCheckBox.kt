package com.gowittgroup.uishift.components

import UiShiftColorScheme
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.theme.ThemeConfig

@Composable
fun UiShiftCheckBox(
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit,
    colorScheme: UiShiftColorScheme = ThemeConfig.colorScheme // Accept the color scheme as a parameter
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = colorScheme.checkboxCheckedColor, // Checked color from color scheme
            uncheckedColor = colorScheme.checkboxUncheckedColor, // Unchecked color from color scheme
            disabledCheckedColor = colorScheme.checkboxDisabledColor // Disabled color from color scheme
        )
    )
}