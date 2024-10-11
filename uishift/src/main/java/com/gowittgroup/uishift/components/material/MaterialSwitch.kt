package com.gowittgroup.uishift.components.material

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable

@Composable
fun MaterialSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}