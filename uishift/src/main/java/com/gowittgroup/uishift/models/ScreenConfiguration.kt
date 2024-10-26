package com.gowittgroup.uishift.models

import com.gowittgroup.uishift.models.components.UIComponent
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScreenConfiguration(
    val components: List<UIComponent>
)