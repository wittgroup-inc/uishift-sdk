package com.gowittgroup.uishift.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


@Composable
fun uiShiftTextStyle(token: String): TextStyle {
    return when (token) {
        // Custom tokens for display styles
        "mainTitle" -> MaterialTheme.typography.displayLarge.copy(
            color = Color.Black
        )

        "sectionTitle" -> MaterialTheme.typography.displayMedium.copy(
            color = Color.Black
        )

        "subSectionTitle" -> MaterialTheme.typography.displaySmall.copy(
            color = Color.Black
        )

        // Custom tokens for headline styles
        "primaryHeader" -> MaterialTheme.typography.headlineLarge.copy(
            color = Color.Black
        )

        "secondaryHeader" -> MaterialTheme.typography.headlineMedium.copy(
            color = Color.Black
        )

        "tertiaryHeader" -> MaterialTheme.typography.headlineSmall.copy(
            color = Color.Black
        )

        // Custom tokens for title styles
        "primaryTitle" -> MaterialTheme.typography.titleLarge.copy(
            color = Color.Blue
        )

        "secondaryTitle" -> MaterialTheme.typography.titleMedium.copy(
            color = Color.Blue
        )

        "tertiaryTitle" -> MaterialTheme.typography.titleSmall.copy(
            color = Color.Blue
        )

        // Custom tokens for body text
        "mainContent" -> MaterialTheme.typography.bodyLarge.copy(
            color = Color.Gray
        )

        "secondaryContent" -> MaterialTheme.typography.bodyMedium.copy(
            color = Color.Gray
        )

        "smallContent" -> MaterialTheme.typography.bodySmall.copy(
            color = Color.Gray
        )

        // Custom tokens for labels
        "primaryLabel" -> MaterialTheme.typography.labelLarge.copy(
            color = Color.DarkGray
        )

        "secondaryLabel" -> MaterialTheme.typography.labelMedium.copy(
            color = Color.DarkGray
        )

        "smallLabel" -> MaterialTheme.typography.labelSmall.copy(
            color = Color.DarkGray
        )

        // Default fallback
        else -> MaterialTheme.typography.bodyMedium.copy(
            color = Color.Black
        )
    }
}