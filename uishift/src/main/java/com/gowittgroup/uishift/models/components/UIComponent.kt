package com.gowittgroup.uishift.models.components

import com.gowittgroup.uishift.models.properties.common.Alignment
import com.gowittgroup.uishift.models.properties.common.Interactions
import com.gowittgroup.uishift.models.properties.common.SizeOption
import com.gowittgroup.uishift.models.properties.common.Visibility
import com.gowittgroup.uishift.models.properties.common.Accessibility
import com.gowittgroup.uishift.models.properties.common.animation.Animation
import com.gowittgroup.uishift.models.properties.common.background.Background
import com.gowittgroup.uishift.models.properties.common.Padding
import com.gowittgroup.uishift.models.properties.common.shape.Shape

sealed class UIComponent {
    abstract val id: String
    abstract val padding: Padding
    abstract val background: Background?
    abstract val shape: Shape?
    abstract val visibility: Visibility
    abstract val alignment: Alignment
    abstract val animation: Animation?
    abstract val interactions: Interactions
    abstract val accessibility: Accessibility?
    abstract val width: SizeOption? // Width can be FillMax, WrapContent, or Fixed
    abstract val height: SizeOption? // Height can be FillMax, WrapContent, or Fixed // Height can be FillMax, WrapContent, or Fixed
}