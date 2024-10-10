package com.gowittgroup.uishift.components.material

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MaterialButton(token: String, label: String, onClick: () -> Unit) {
    val colorScheme = MaterialTheme.colorScheme // Get the Material3 color scheme

    when (token) {
        "primaryButton" -> {
            Button(
                onClick = onClick,
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                )
            ) {
                Text(label)
            }
        }
        "secondaryButton" -> {
            ElevatedButton(
                onClick = onClick,
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.secondary,
                    contentColor = colorScheme.onSecondary
                )
            ) {
                Text(label)
            }
        }
        "tertiaryButton" -> {
            FilledTonalButton(
                onClick = onClick,
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.tertiary,
                    contentColor = colorScheme.onTertiary
                )
            ) {
                Text(label)
            }
        }
        "outlinedButton" -> {
            OutlinedButton(
                onClick = onClick,
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent, // Outlined button background is usually transparent
                    contentColor = colorScheme.primary,
                    disabledContainerColor = colorScheme.surface, // Optional, set a surface color when disabled
                    disabledContentColor = colorScheme.onSurfaceVariant // Optional, set a variant color when disabled
                )
            ) {
                Text(label)
            }
        }
        "destructiveButton" -> {
            Button(
                onClick = onClick,
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.error,
                    contentColor = colorScheme.onError
                )
            ) {
                Text(label)
            }
        }
        // Default button style
        else -> {
            Button(
                onClick = onClick,
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                )
            ) {
                Text(label)
            }
        }
    }
}
