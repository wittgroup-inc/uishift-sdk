package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gowittgroup.uishift.screen.ScreenState
import com.gowittgroup.uishift.components.UiShiftSwitch
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderSwitchComponent(
    screenState: ScreenState,
    component: UIComponent.SwitchComponent,
    onCheckedChange: (Boolean) -> Unit
) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    isChecked = screenState.switchState[component.id] ?: component.isChecked

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
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
