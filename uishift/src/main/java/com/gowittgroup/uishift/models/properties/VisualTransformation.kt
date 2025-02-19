package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.Json

enum class VisualTransformation {
    @Json(name = "none")
    NONE,

    @Json(name = "password")
    PASSWORD,

    @Json(name = "capitalize")
    CAPITALIZE
}