package com.gowittgroup.uishift.models.properties.common

import com.squareup.moshi.Json

// Alignment
enum class Alignment {
    @Json(name = "start")
    START,

    @Json(name = "center")
    CENTER,

    @Json(name = "end")
    END,

    @Json(name = "top")
    TOP,

    @Json(name = "bottom")
    BOTTOM
}