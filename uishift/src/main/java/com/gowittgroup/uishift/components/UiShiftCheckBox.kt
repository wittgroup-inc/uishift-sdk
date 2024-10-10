package com.gowittgroup.uishift.components

import UiShiftColorScheme
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.theme.ThemeConfig
import com.gowittgroup.uishift.theme.ThemeConfig.colorScheme

@Composable
fun UiShiftCheckBox(
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = colorScheme.checkboxCheckedColor,
            uncheckedColor = colorScheme.checkboxUncheckedColor,
            disabledCheckedColor = colorScheme.checkboxDisabledColor
        )
    )
}