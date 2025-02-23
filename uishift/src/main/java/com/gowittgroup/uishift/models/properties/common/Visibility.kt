package com.gowittgroup.uishift.models.properties.common

import com.squareup.moshi.Json

enum class Visibility {
    @Json(name = "visible")
    VISIBLE,

    @Json(name = "gone")
    GONE
}