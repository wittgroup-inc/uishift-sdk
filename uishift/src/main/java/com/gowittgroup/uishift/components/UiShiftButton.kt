package com.gowittgroup.uishift.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.constants.ButtonStyleToken
import com.gowittgroup.uishift.theme.ThemeConfig.colorScheme


@Composable
fun UiShiftButton(
    modifier: Modifier = Modifier,
    token: String,
    label: String,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    when (token) {
        ButtonStyleToken.PRIMARY_BUTTON -> {
            Button(
                enabled = isEnabled,
                onClick = onClick,
                modifier = modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.primaryButtonBackground,
                    contentColor = colorScheme.primaryButtonTextColor,
                    disabledContainerColor = colorScheme.primaryButtonDisabledBackground,
                    disabledContentColor = colorScheme.primaryButtonDisabledTextColor
                )
            ) {
                Text(label)
            }
        }

        ButtonStyleToken.SECONDARY_BUTTON -> {
            ElevatedButton(
                onClick = onClick,
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.secondaryButtonBackground,
                    contentColor = colorScheme.secondaryButtonTextColor,
                    disabledContainerColor = colorScheme.secondaryButtonDisabledBackground,
                    disabledContentColor = colorScheme.secondaryButtonDisabledTextColor
                )
            ) {
                Text(label)
            }
        }

        ButtonStyleToken.TERTIARY_BUTTON -> {
            FilledTonalButton(
                onClick = onClick,
                modifier = modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.tertiaryButtonBackground,
                    contentColor = colorScheme.tertiaryButtonTextColor,
                    disabledContainerColor = colorScheme.tertiaryButtonDisabledBackground,
                    disabledContentColor = colorScheme.tertiaryButtonDisabledTextColor
                )
            ) {
                Text(label)
            }
        }

        ButtonStyleToken.OUTLINED_BUTTON -> {
            OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = colorScheme.outlinedButtonBorderColor,
                    contentColor = colorScheme.outlinedButtonTextColor,
                    disabledContentColor = colorScheme.outlinedButtonDisabledTextColor,
                    disabledContainerColor = colorScheme.outlinedButtonDisabledBorderColor
                )
            ) {
                Text(label)
            }
        }

        ButtonStyleToken.DESTRUCTIVE_BUTTON -> {
            Button(
                onClick = onClick,
                modifier = modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.destructiveButtonBackground,
                    contentColor = colorScheme.destructiveButtonTextColor,
                    disabledContainerColor = colorScheme.destructiveButtonDisabledBackground,
                    disabledContentColor = colorScheme.destructiveButtonDisabledTextColor
                )
            ) {
                Text(label)
            }
        }
        // Add more custom button styles as needed
        else -> {
            // Default button style
            Button(
                onClick = onClick,
                modifier = modifier
            ) {
                Text(label, color = Color.White)
            }
        }
    }
}

