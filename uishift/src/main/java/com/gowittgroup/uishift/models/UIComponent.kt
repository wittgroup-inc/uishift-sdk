package com.gowittgroup.uishift.models

import com.squareup.moshi.JsonClass

sealed class UIComponent {
    abstract val id: String // Add id to all components

    @JsonClass(generateAdapter = true)
    data class TextComponent(
        val content: String,
        val style: String,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class ButtonComponent(
        val style: String,
        val label: String,
        val onClickAction: Action,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class ImageComponent(
        val url: String,
        val description: String,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class ColumnComponent(
        val children: List<UIComponent>,
        val isScrollable: Boolean = false,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class RowComponent(
        val children: List<UIComponent>,
        val isScrollable: Boolean = false,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class TextFieldComponent(
        val label: String,
        val hint: String,
        val initialValue: String = "",
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class CheckBoxComponent(
        val label: String,
        val isChecked: Boolean = false,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class SliderComponent(
        val min: Float,
        val max: Float,
        val initialValue: Float,
        override val id: String
    ) : UIComponent()

    data object Unknown : UIComponent() {
        override val id: String = "unknown"
    }
}
