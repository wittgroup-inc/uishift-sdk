package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.Json

enum class SwipeDirection {
    @Json(name = "left")
    LEFT,

    @Json(name = "right")
    RIGHT,

    @Json(name = "up")
    UP,

    @Json(name = "down")
    DOWN
}