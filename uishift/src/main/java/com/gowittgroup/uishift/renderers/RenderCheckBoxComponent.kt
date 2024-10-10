package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.ScreenState
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderCheckBoxComponent(
    screenState: ScreenState,
    component: UIComponent.CheckBoxComponent
) {
    val isChecked = screenState.checkBoxState[component.id] ?: component.isChecked
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                screenState.updateCheckBoxState(component.id, it)
            }
        )
        Text(component.label)
    }
}