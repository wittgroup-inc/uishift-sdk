package com.gowittgroup.uishift.components

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.theme.ThemeConfig.colorScheme

@Composable
fun UiShiftSwitch(
    checked: Boolean,
    isEnabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        enabled = isEnabled,
        colors = SwitchDefaults.colors(
            checkedTrackColor = colorScheme.switchOnTrackColor,
            uncheckedTrackColor = colorScheme.switchOffTrackColor,
            checkedThumbColor = colorScheme.switchOnThumbColor,
            uncheckedThumbColor = colorScheme.switchOffThumbColor,
            disabledCheckedThumbColor = colorScheme.switchDisabledThumbColor,
            disabledCheckedTrackColor = colorScheme.switchDisabledTrackColor
        )
    )
}