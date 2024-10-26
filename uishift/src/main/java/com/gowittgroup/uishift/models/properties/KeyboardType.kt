package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.Json

enum class KeyboardType {
    @Json(name = "text")
    TEXT,

    @Json(name = "number")
    NUMBER,

    @Json(name = "email")
    EMAIL,

    @Json(name = "phone")
    PHONE,

    @Json(name = "password")
    PASSWORD
}