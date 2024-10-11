package com.gowittgroup.uishift.models

import com.squareup.moshi.Json

enum class Direction {
    @Json(name = "horizontal")
    HORIZONTAL,

    @Json(name = "vertical")
    VERTICAL
}