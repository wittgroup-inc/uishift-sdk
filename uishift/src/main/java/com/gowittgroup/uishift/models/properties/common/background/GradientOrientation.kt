package com.gowittgroup.uishift.models.properties.common.background

import com.squareup.moshi.Json

enum class GradientOrientation {
    @Json(name = "vertical")
    VERTICAL,

    @Json(name = "horizontal")
    HORIZONTAL,

    @Json(name = "diagonal")
    DIAGONAL
}