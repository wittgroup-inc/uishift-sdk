package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.screen.ScreenState
import com.gowittgroup.uishift.components.UiShiftCheckBox
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderCheckBoxComponent(
    screenState: ScreenState,
    component: UIComponent.CheckBoxComponent,
    onCheckedChange: (Boolean) -> Unit
) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    isChecked = screenState.checkBoxState[component.id] ?: component.isChecked
    Row(verticalAlignment = Alignment.CenterVertically) {
        UiShiftCheckBox(
            isEnabled = component.isEnabled,
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
        Text(component.label)
    }
}