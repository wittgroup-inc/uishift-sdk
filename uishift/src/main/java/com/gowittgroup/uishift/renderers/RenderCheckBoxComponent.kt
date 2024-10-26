package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.components.UiShiftCheckBox
import com.gowittgroup.uishift.components.UiShiftText
import com.gowittgroup.uishift.models.components.CheckBoxComponent
import com.gowittgroup.uishift.screen.ScreenState

@Composable
fun RenderCheckBoxComponent(
    screenState: ScreenState,
    component: CheckBoxComponent,
    onCheckedChange: (Boolean) -> Unit
) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    isChecked = screenState.checkBoxState[component.id] ?: component.isChecked
    RenderBaseProperties(component) { modifier ->
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
            UiShiftCheckBox(
                isEnabled = component.isEnabled,
                checked = isChecked,
                onCheckedChange = onCheckedChange
            )
            UiShiftText(text = component.label)
        }
    }
}