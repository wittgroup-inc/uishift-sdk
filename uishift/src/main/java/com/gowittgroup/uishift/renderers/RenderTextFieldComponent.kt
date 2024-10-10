package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.ScreenState
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderTextFieldComponent(
    screenState: ScreenState,
    component: UIComponent.TextFieldComponent
) {
    var text by remember {
        mutableStateOf(
            screenState.textFieldsState[component.id] ?: component.initialValue
        )
    }
    TextField(
        value = text,
        onValueChange = {
            text = it
            screenState.updateTextFieldState(component.id, it)
        },
        label = { Text(component.label) },
        placeholder = { Text(component.hint) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}