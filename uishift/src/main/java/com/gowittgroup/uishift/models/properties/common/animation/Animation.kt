package com.gowittgroup.uishift.models.properties.common.animation

data class Animation(
    val type: AnimationType,
    val duration: Long = 300L,  // Duration in milliseconds
    val delay: Long = 0L  // Delay before starting animation
)