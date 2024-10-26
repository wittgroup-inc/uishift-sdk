package com.gowittgroup.uishift.models.properties.common

import com.gowittgroup.uishift.models.properties.ActionFlow
import com.gowittgroup.uishift.models.properties.SwipeAction

// Interactions
data class Interactions(
    val onClick: ActionFlow? = null,
    val onLongPress: ActionFlow? = null,
    val onSwipe: SwipeAction? = null
)