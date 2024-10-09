package com.gowittgroup.uishift.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UiShiftButton(token: String, label: String, onClick: () -> Unit) {
    when (token) {
        "primaryButton" -> {
            Button(
                onClick = onClick,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(label, color = Color.White)
            }
        }
        "secondaryButton" -> {
            ElevatedButton(
                onClick = onClick,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(label, color = Color.Black)
            }
        }
        "tertiaryButton" -> {
            FilledTonalButton(
                onClick = onClick,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(label, color = Color.White)
            }
        }
        "outlinedButton" -> {
            OutlinedButton(
                onClick = onClick,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(label, color = Color.Black)
            }
        }
        "destructiveButton" -> {
            Button(
                onClick = onClick,
                modifier = Modifier.padding(8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text(label, color = Color.White)
            }
        }
        // Add more custom button styles as needed
        else -> {
            // Default button style
            Button(
                onClick = onClick,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(label, color = Color.White)
            }
        }
    }
}
