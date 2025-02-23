package com.gowittgroup.uishift.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import com.gowittgroup.uishift.theme.ThemeConfig.colorScheme

@Composable
fun UiShiftTextField(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    label: String,
    hint: String,
    isEnabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value = value,
        enabled = isEnabled,
        readOnly = readOnly,
        isError = isError,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        label = {
            Text(
                label,
                color = colorScheme.labelTextColor
            )
        },
        placeholder = {
            Text(
                hint,
                color = colorScheme.bodyTextColor
            )
        },
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorScheme.textFieldBackground,
            unfocusedContainerColor = colorScheme.textFieldBackground,
            disabledContainerColor = colorScheme.textFieldDisabledBackground,
            focusedTextColor = colorScheme.textFieldTextColor,
            unfocusedTextColor = colorScheme.textFieldTextColor,
            focusedIndicatorColor = colorScheme.textFieldFocusedBorderColor,
            unfocusedIndicatorColor = colorScheme.textFieldBorderColor,
            disabledIndicatorColor = colorScheme.textFieldDisabledBorderColor
        ),
    )
}
