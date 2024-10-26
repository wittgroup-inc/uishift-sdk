package com.gowittgroup.uishift.models.properties.common.background

data class Background(
    val color: String = "#FFFFFF",  // Default white background
    val gradient: Gradient? = null,
    val image: String? = null  // URL to background image if any
)