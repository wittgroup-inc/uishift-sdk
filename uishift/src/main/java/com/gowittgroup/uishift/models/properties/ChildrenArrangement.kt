package com.gowittgroup.uishift.models.properties

import androidx.compose.foundation.layout.Arrangement
import com.squareup.moshi.Json

enum class HorizontalArrangement {
    @Json(name = "start") START,       // Equivalent to Arrangement.Start
    @Json(name = "end") END,           // Equivalent to Arrangement.End
    @Json(name = "center") CENTER,     // Equivalent to Arrangement.Center
    @Json(name = "spaceBetween") SPACE_BETWEEN, // Equivalent to Arrangement.SpaceBetween
    @Json(name = "spaceAround") SPACE_AROUND,   // Equivalent to Arrangement.SpaceAround
    @Json(name = "spaceEvenly") SPACE_EVENLY    // Equivalent to Arrangement.SpaceEvenly
}

enum class VerticalArrangement {
    @Json(name = "top") TOP,       // Equivalent to Arrangement.Start
    @Json(name = "bottom") BOTTOM,           // Equivalent to Arrangement.End
    @Json(name = "center") CENTER,     // Equivalent to Arrangement.Center
    @Json(name = "spaceBetween") SPACE_BETWEEN, // Equivalent to Arrangement.SpaceBetween
    @Json(name = "spaceAround") SPACE_AROUND,   // Equivalent to Arrangement.SpaceAround
    @Json(name = "spaceEvenly") SPACE_EVENLY    // Equivalent to Arrangement.SpaceEvenly
}

fun HorizontalArrangement.toHorizontalArrangement(): Arrangement.Horizontal {
    return when (this) {
        HorizontalArrangement.START -> Arrangement.Start
        HorizontalArrangement.END -> Arrangement.End
        HorizontalArrangement.CENTER -> Arrangement.Center
        HorizontalArrangement.SPACE_BETWEEN -> Arrangement.SpaceBetween
        HorizontalArrangement.SPACE_AROUND -> Arrangement.SpaceAround
        HorizontalArrangement.SPACE_EVENLY -> Arrangement.SpaceEvenly
    }
}

fun VerticalArrangement.toVerticalArrangement(): Arrangement.Vertical {
    return when (this) {
        VerticalArrangement.TOP -> Arrangement.Top
        VerticalArrangement.BOTTOM -> Arrangement.Bottom
        VerticalArrangement.CENTER -> Arrangement.Center
        VerticalArrangement.SPACE_BETWEEN -> Arrangement.SpaceBetween
        VerticalArrangement.SPACE_AROUND -> Arrangement.SpaceAround
        VerticalArrangement.SPACE_EVENLY -> Arrangement.SpaceEvenly
    }
}