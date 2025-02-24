package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.Json

typealias ComposeAlignment = androidx.compose.ui.Alignment
typealias ComposeAlignmentHorizontal = androidx.compose.ui.Alignment.Horizontal
typealias ComposeAlignmentVertical = androidx.compose.ui.Alignment.Vertical

enum class HorizontalAlignment {
    @Json(name = "start") START,
    @Json(name = "center") CENTER,
    @Json(name = "end") END
}

enum class VerticalAlignment {
    @Json(name = "top") TOP,
    @Json(name = "bottom") BOTTOM,
    @Json(name = "center") CENTER
}

fun HorizontalAlignment.toHorizontalAlignment(): ComposeAlignmentHorizontal {
    return when (this) {
        HorizontalAlignment.START -> ComposeAlignment.Start
        HorizontalAlignment.END -> ComposeAlignment.End
        HorizontalAlignment.CENTER -> ComposeAlignment.CenterHorizontally
    }
}

fun VerticalAlignment.toVerticalAlignment(): ComposeAlignmentVertical {
    return when (this) {
        VerticalAlignment.TOP -> ComposeAlignment.Top
        VerticalAlignment.BOTTOM -> ComposeAlignment.Bottom
        VerticalAlignment.CENTER -> ComposeAlignment.CenterVertically
    }
}