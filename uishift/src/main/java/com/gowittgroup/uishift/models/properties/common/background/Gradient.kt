package com.gowittgroup.uishift.models.properties.common.background

data class Gradient(
    val startColor: String,
    val endColor: String,
    val orientation: GradientOrientation = GradientOrientation.VERTICAL
)