package com.gowittgroup.uishift.models.components

import com.gowittgroup.uishift.models.properties.Validation
import com.gowittgroup.uishift.models.properties.common.Alignment
import com.gowittgroup.uishift.models.properties.common.Interactions
import com.gowittgroup.uishift.models.properties.common.SizeOption
import com.gowittgroup.uishift.models.properties.common.Visibility
import com.gowittgroup.uishift.models.properties.common.Accessibility
import com.gowittgroup.uishift.models.properties.common.animation.Animation
import com.gowittgroup.uishift.models.properties.common.background.Background
import com.gowittgroup.uishift.models.properties.common.Padding
import com.gowittgroup.uishift.models.properties.common.shape.Shape
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SliderComponent(
    val min: Float,
    val max: Float,
    val initialValue: Float,
    val isEnabled: Boolean = true,
    val validation: Validation = Validation.None(),
    override val id: String,
    // Pass all properties to the BaseComponent
    override val padding: Padding = Padding(),
    override val background: Background? = null,
    override val shape: Shape? = null,
    override val visibility: Visibility = Visibility.VISIBLE,
    override val alignment: Alignment = Alignment.START,
    override val animation: Animation? = null,
    override val interactions: Interactions = Interactions(),
    override val accessibility: Accessibility? = null,
    override val width: SizeOption? = null,
    override val height: SizeOption? = null
) : UIComponent()
