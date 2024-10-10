package com.gowittgroup.uishift.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.gowittgroup.uishift.constants.TextStyleToken


@Composable
fun materialTextStyle(token: String): TextStyle {
    val colorScheme = MaterialTheme.colorScheme // Access the Material 3 color scheme

    return when (token) {
        // Custom tokens for display styles
        TextStyleToken.MAIN_TITLE -> MaterialTheme.typography.displayLarge.copy(
            color = colorScheme.onBackground // or any color from the color scheme
        )

        TextStyleToken.SECTION_TITLE -> MaterialTheme.typography.displayMedium.copy(
            color = colorScheme.onBackground
        )

        TextStyleToken.SUB_SECTION_TITLE -> MaterialTheme.typography.displaySmall.copy(
            color = colorScheme.onBackground
        )

        // Custom tokens for headline styles
        TextStyleToken.PRIMARY_HEADER -> MaterialTheme.typography.headlineLarge.copy(
            color = colorScheme.onBackground
        )

        TextStyleToken.SECONDARY_HEADER -> MaterialTheme.typography.headlineMedium.copy(
            color = colorScheme.onBackground
        )

        TextStyleToken.TERTIARY_HEADER -> MaterialTheme.typography.headlineSmall.copy(
            color = colorScheme.onBackground
        )

        // Custom tokens for title styles
        TextStyleToken.PRIMARY_TITLE -> MaterialTheme.typography.titleLarge.copy(
            color = colorScheme.primary // Use primary color for titles
        )

        TextStyleToken.SECONDARY_TITLE -> MaterialTheme.typography.titleMedium.copy(
            color = colorScheme.primary
        )

        TextStyleToken.TERTIARY_TITLE -> MaterialTheme.typography.titleSmall.copy(
            color = colorScheme.primary
        )

        // Custom tokens for body text
        TextStyleToken.MAIN_CONTENT -> MaterialTheme.typography.bodyLarge.copy(
            color = colorScheme.onSurface // Use onSurface color for body content
        )

        TextStyleToken.SECONDARY_CONTENT -> MaterialTheme.typography.bodyMedium.copy(
            color = colorScheme.onSurface
        )

        TextStyleToken.SMALL_CONTENT -> MaterialTheme.typography.bodySmall.copy(
            color = colorScheme.onSurface
        )

        // Custom tokens for labels
        TextStyleToken.PRIMARY_LABEL -> MaterialTheme.typography.labelLarge.copy(
            color = colorScheme.onSurfaceVariant // Use onSurfaceVariant color for labels
        )

        TextStyleToken.SECONDARY_LABEL -> MaterialTheme.typography.labelMedium.copy(
            color = colorScheme.onSurfaceVariant
        )

        TextStyleToken.SMALL_LABEL -> MaterialTheme.typography.labelSmall.copy(
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
        TextStyleToken.MAIN_TITLE -> ThemeConfig.typography.mainTitle.copy(
            color = colorScheme.mainTitleTextColor
        )

        TextStyleToken.SECTION_TITLE -> ThemeConfig.typography.sectionTitle.copy(
            color = colorScheme.sectionTitleTextColor
        )

        TextStyleToken.SUB_SECTION_TITLE -> ThemeConfig.typography.subSectionTitle.copy(
            color = colorScheme.subSectionTitleTextColor
        )

        // Custom tokens for headline styles
        TextStyleToken.PRIMARY_HEADER -> ThemeConfig.typography.primaryHeader.copy(
            color = colorScheme.primaryHeaderTextColor
        )

        TextStyleToken.SECONDARY_HEADER -> ThemeConfig.typography.secondaryHeader.copy(
            color = colorScheme.secondaryHeaderTextColor
        )

        TextStyleToken.TERTIARY_HEADER -> ThemeConfig.typography.tertiaryHeader.copy(
            color = colorScheme.tertiaryHeaderTextColor
        )

        // Custom tokens for title styles
        TextStyleToken.PRIMARY_TITLE -> ThemeConfig.typography.primaryTitle.copy(
            color = colorScheme.primaryTitleTextColor
        )

        TextStyleToken.SECONDARY_TITLE -> ThemeConfig.typography.secondaryTitle.copy(
            color = colorScheme.secondaryTitleTextColor
        )

        TextStyleToken.TERTIARY_TITLE -> ThemeConfig.typography.tertiaryTitle.copy(
            color = colorScheme.tertiaryTitleTextColor
        )

        // Custom tokens for body text
        TextStyleToken.MAIN_CONTENT -> ThemeConfig.typography.mainContent.copy(
            color = colorScheme.bodyTextColor
        )

        TextStyleToken.SECONDARY_CONTENT -> ThemeConfig.typography.secondaryContent.copy(
            color = colorScheme.labelTextColor
        )

        TextStyleToken.SMALL_CONTENT -> ThemeConfig.typography.smallContent.copy(
            color = colorScheme.labelTextColor
        )

        // Custom tokens for labels
        TextStyleToken.PRIMARY_LABEL -> ThemeConfig.typography.primaryLabel.copy(
            color = colorScheme.labelTextColor
        )

        TextStyleToken.SECONDARY_LABEL -> ThemeConfig.typography.secondaryLabel.copy(
            color = colorScheme.secondaryLabelTextColor
        )

        TextStyleToken.SMALL_LABEL -> ThemeConfig.typography.smallLabel.copy(
            color = colorScheme.labelTextColor
        )

        // Default fallback
        else -> ThemeConfig.typography.secondaryContent.copy(
            color = colorScheme.bodyTextColor
        )
    }
}