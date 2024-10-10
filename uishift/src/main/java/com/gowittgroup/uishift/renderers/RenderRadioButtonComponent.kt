package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.ScreenState
import com.gowittgroup.uishift.models.UIComponent
import com.gowittgroup.uishift.components.UiShiftRadioButton

@Composable
fun RenderRadioButtonComponent(
    screenState: ScreenState,
    component: UIComponent.RadioButtonComponent
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        val isSelected = screenState.radioButtonState[component.id] ?: component.isSelected
        UiShiftRadioButton(
            selected = isSelected,
            onClick = {
                screenState.updateRadioButtonState(component.id, isSelected)
            }
        )
        Text(component.label)
    }
}
