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

    @JsonClass(generateAdapter = true)
    data class SwitchComponent(
        val label: String,
        val isChecked: Boolean, // Initial state (checked or unchecked)
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class RadioButtonComponent(
        val label: String,
        val isSelected: Boolean, // Initially selected option (if any)
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class DividerComponent(
        val thickness: Int = 1, // Thickness of the divider line
        val color: String = "#000000", // Color of the divider in hex
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class SpacerComponent(
        val height: Int = 16, // Height of the spacer
        override val id: String
    ) : UIComponent()

    data object Unknown : UIComponent() {
        override val id: String = "unknown"
    }
}
