package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.Json

enum class ImeAction {
    @Json(name = "done")
    DONE,

    @Json(name = "go")
    GO,

    @Json(name = "next")
    NEXT,

    @Json(name = "search")
    SEARCH,

    @Json(name = "send")
    SEND
}