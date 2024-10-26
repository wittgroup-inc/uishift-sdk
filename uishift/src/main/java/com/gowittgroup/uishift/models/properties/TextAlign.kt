package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.Json

enum class TextAlign {
    @Json(name = "start")
    START,

    @Json(name = "center")
    CENTER,

    @Json(name = "end")
    END,

    @Json(name = "justify")
    JUSTIFY
}