package com.gowittgroup.uishift.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle


@Composable
fun materialTextStyle(token: String): TextStyle {
    val colorScheme = MaterialTheme.colorScheme // Access the Material 3 color scheme

    return when (token) {
        // Custom tokens for display styles
        "mainTitle" -> MaterialTheme.typography.displayLarge.copy(
            color = colorScheme.onBackground // or any color from the color scheme
        )

        "sectionTitle" -> MaterialTheme.typography.displayMedium.copy(
            color = colorScheme.onBackground
        )

        "subSectionTitle" -> MaterialTheme.typography.displaySmall.copy(
            color = colorScheme.onBackground
        )

        // Custom tokens for headline styles
        "primaryHeader" -> MaterialTheme.typography.headlineLarge.copy(
            color = colorScheme.onBackground
        )

        "secondaryHeader" -> MaterialTheme.typography.headlineMedium.copy(
            color = colorScheme.onBackground
        )

        "tertiaryHeader" -> MaterialTheme.typography.headlineSmall.copy(
            color = colorScheme.onBackground
        )

        // Custom tokens for title styles
        "primaryTitle" -> MaterialTheme.typography.titleLarge.copy(
            color = colorScheme.primary // Use primary color for titles
        )

        "secondaryTitle" -> MaterialTheme.typography.titleMedium.copy(
            color = colorScheme.primary
        )

        "tertiaryTitle" -> MaterialTheme.typography.titleSmall.copy(
            color = colorScheme.primary
        )

        // Custom tokens for body text
        "mainContent" -> MaterialTheme.typography.bodyLarge.copy(
            color = colorScheme.onSurface // Use onSurface color for body content
        )

        "secondaryContent" -> MaterialTheme.typography.bodyMedium.copy(
            color = colorScheme.onSurface
        )

        "smallContent" -> MaterialTheme.typography.bodySmall.copy(
            color = colorScheme.onSurface
        )

        // Custom tokens for labels
        "primaryLabel" -> MaterialTheme.typography.labelLarge.copy(
            color = colorScheme.onSurfaceVariant // Use onSurfaceVariant color for labels
        )

        "secondaryLabel" -> MaterialTheme.typography.labelMedium.copy(
            color = colorScheme.onSurfaceVariant
        )

        "smallLabel" -> MaterialTheme.typography.labelSmall.copy(
            color = colorScheme.onSurfaceVariant
        )

        // Default fallback
        else -> MaterialTheme.typography.bodyMedium.copy(
            color = colorScheme.onBackground // Fallback to onBackground
        )
    }
}

@Composable
fun uiShiftTextStyle(token: String): TextStyle {
    val colorScheme = ThemeConfig.colorScheme

    return when (token) {
        // Custom tokens for display styles
        "mainTitle" -> ThemeConfig.typography.mainTitle.copy(
            color = colorScheme.mainTitleTextColor
        )

        "sectionTitle" -> ThemeConfig.typography.sectionTitle.copy(
            color = colorScheme.sectionTitleTextColor
        )

        "subSectionTitle" -> ThemeConfig.typography.subSectionTitle.copy(
            color = colorScheme.subSectionTitleTextColor
        )

        // Custom tokens for headline styles
        "primaryHeader" -> ThemeConfig.typography.primaryHeader.copy(
            color = colorScheme.primaryHeaderTextColor
        )

        "secondaryHeader" -> ThemeConfig.typography.secondaryHeader.copy(
            color = colorScheme.secondaryHeaderTextColor
        )

        "tertiaryHeader" -> ThemeConfig.typography.tertiaryHeader.copy(
            color = colorScheme.tertiaryHeaderTextColor
        )

        // Custom tokens for title styles
        "primaryTitle" -> ThemeConfig.typography.primaryTitle.copy(
            color = colorScheme.primaryTitleTextColor
        )

        "secondaryTitle" -> ThemeConfig.typography.secondaryTitle.copy(
            color = colorScheme.secondaryTitleTextColor
        )

        "tertiaryTitle" -> ThemeConfig.typography.tertiaryTitle.copy(
            color = colorScheme.tertiaryTitleTextColor
        )

        // Custom tokens for body text
        "mainContent" -> ThemeConfig.typography.mainContent.copy(
            color = colorScheme.bodyTextColor
        )

        "secondaryContent" -> ThemeConfig.typography.secondaryContent.copy(
            color = colorScheme.labelTextColor
        )

        "smallContent" -> ThemeConfig.typography.smallContent.copy(
            color = colorScheme.labelTextColor
        )

        // Custom tokens for labels
        "primaryLabel" -> ThemeConfig.typography.primaryLabel.copy(
            color = colorScheme.labelTextColor
        )

        "secondaryLabel" -> ThemeConfig.typography.secondaryLabel.copy(
            color = colorScheme.secondaryLabelTextColor
        )

        "smallLabel" -> ThemeConfig.typography.smallLabel.copy(
            color = colorScheme.labelTextColor
        )

        // Default fallback
        else -> ThemeConfig.typography.secondaryContent.copy(
            color = colorScheme.bodyTextColor
        )
    }
}