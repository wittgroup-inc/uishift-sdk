package com.gowittgroup.uishift.models

import com.squareup.moshi.Json

enum class ScaleType {
    @Json(name = "crop")
    CROP,

    @Json(name = "fit")
    FIT,

    @Json(name = "fillBounds")
    FILL_BOUNDS
}