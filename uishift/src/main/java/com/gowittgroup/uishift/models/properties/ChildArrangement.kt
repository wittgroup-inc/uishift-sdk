package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChildArrangement(
    val direction: ArrangementDirection = ArrangementDirection.VERTICAL, // Defines the arrangement direction
    val spacing: Int = 8, // Spacing between child components
    val alignment: ChildAlignment = ChildAlignment.START, // Alignment of child components
    val isWrap: Boolean = false // Indicates whether to wrap child components in the next line
)

enum class ArrangementDirection {
    HORIZONTAL,
    VERTICAL,
    GRID
}

enum class ChildAlignment {
    START,
    CENTER,
    END,
    STRETCH
}