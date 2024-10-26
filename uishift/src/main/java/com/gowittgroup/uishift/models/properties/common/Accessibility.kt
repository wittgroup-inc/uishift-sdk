package com.gowittgroup.uishift.models.properties.common

data class Accessibility(
    val description: String? = null,
    val isFocusable: Boolean = true,
    val isClickable: Boolean = false
)