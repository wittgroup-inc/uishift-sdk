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
import com.gowittgroup.uishift.components.UiShiftRadioButton
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderRadioButtonComponent(
    screenState: ScreenState,
    component: UIComponent.RadioButtonComponent,
    onClick: () -> Unit
) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    isSelected = screenState.radioButtonState[component.id] ?: component.isSelected
    Row(verticalAlignment = Alignment.CenterVertically) {

        UiShiftRadioButton(
            isEnabled = component.isEnabled,
            selected = isSelected,
            onClick = onClick
        )
        Text(component.label)
    }
}
