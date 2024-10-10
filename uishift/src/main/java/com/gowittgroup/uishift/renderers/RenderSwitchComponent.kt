package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gowittgroup.uishift.ScreenState
import com.gowittgroup.uishift.models.UIComponent
import com.gowittgroup.uishift.components.UiShiftSwitch

@Composable
fun RenderSwitchComponent(
    screenState: ScreenState,
    component: UIComponent.SwitchComponent
) {
    val isChecked = screenState.switchState[component.id] ?: component.isChecked
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(component.label)
        UiShiftSwitch(
            checked = isChecked,
            onCheckedChange = {
                screenState.updateSwitchState(component.id, it)
            }
        )

    }
}
