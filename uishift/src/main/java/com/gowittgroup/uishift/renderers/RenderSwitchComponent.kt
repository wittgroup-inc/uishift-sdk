package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.components.UiShiftSwitch
import com.gowittgroup.uishift.models.components.SwitchComponent
import com.gowittgroup.uishift.screen.ScreenState

@Composable
fun RenderSwitchComponent(
    screenState: ScreenState,
    component: SwitchComponent,
    onCheckedChange: (Boolean) -> Unit
) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    isChecked = screenState.switchState[component.id] ?: component.isChecked

    RenderBaseProperties(component) { modifier ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(component.label)
            UiShiftSwitch(
                isEnabled = component.isEnabled,
                checked = isChecked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}
