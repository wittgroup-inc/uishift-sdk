package com.gowittgroup.uishift.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScreenConfiguration(
    val components: List<UIComponent>
)