package com.gowittgroup.uishift.models.properties.common.animation

import com.squareup.moshi.Json

enum class AnimationType {
    @Json(name = "fadeIn")
    FADE_IN,

    @Json(name = "fadeOut")
    FADE_OUT,

    @Json(name = "slideIn")
    SLIDE_IN,

    @Json(name = "slideOut")
    SLIDE_OUT,

    @Json(name = "scale")
    SCALE,

    @Json(name = "rotate")
    ROTATE
}