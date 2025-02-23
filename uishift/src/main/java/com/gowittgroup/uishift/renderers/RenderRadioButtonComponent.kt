package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.gowittgroup.uishift.components.UiShiftRadioButton
import com.gowittgroup.uishift.components.UiShiftText
import com.gowittgroup.uishift.models.components.RadioButtonComponent
import com.gowittgroup.uishift.screen.ComponentState

@Composable
fun RenderRadioButtonComponent(
    state: ComponentState.RadioButtonState,
    component: RadioButtonComponent,
    onClick: () -> Unit
) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    isSelected = state.selected

    RenderBaseProperties(component) { modifier ->
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
            UiShiftRadioButton(
                isEnabled = component.isEnabled,
                selected = isSelected,
                onClick = onClick
            )
            UiShiftText(text = component.label)
        }
    }

}
