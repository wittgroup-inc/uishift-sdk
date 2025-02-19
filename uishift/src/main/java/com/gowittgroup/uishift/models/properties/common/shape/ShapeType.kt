package com.gowittgroup.uishift.models.properties.common.shape

import com.squareup.moshi.Json

enum class ShapeType {
    @Json(name = "rectangle")
    RECTANGLE,

    @Json(name = "circle")
    CIRCLE,

    @Json(name = "roundedRectangle")
    ROUNDED_RECTANGLE,

    @Json(name = "oval")
    OVAL
}