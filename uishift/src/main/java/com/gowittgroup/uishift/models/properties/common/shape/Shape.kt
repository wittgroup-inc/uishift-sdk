package com.gowittgroup.uishift.models.properties.common.shape

// Shape
data class Shape(
    val type: ShapeType = ShapeType.RECTANGLE,
    val cornerRadius: Int = 0,
    val borderColor: String? = null,
    val borderWidth: Int = 0
)