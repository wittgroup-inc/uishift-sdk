package com.gowittgroup.uishift.models

import com.squareup.moshi.JsonClass

sealed class UIComponent {
    abstract val id: String

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
        val onClickAction: ActionFlow,
        val isEnabled: Boolean = true,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class ImageComponent(
        val url: String,
        val width: Int? = null,
        val height: Int? = null,
        val description: String,
        val scaleType: ScaleType = ScaleType.FIT,
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
        val isEnabled: Boolean = true,
        val readOnly: Boolean = false,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class CheckBoxComponent(
        val label: String,
        val isChecked: Boolean = false,
        val isEnabled: Boolean = true,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class SliderComponent(
        val min: Float,
        val max: Float,
        val initialValue: Float,
        val isEnabled: Boolean = true,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class SwitchComponent(
        val label: String,
        val isChecked: Boolean,
        val isEnabled: Boolean = true,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class RadioButtonComponent(
        val label: String,
        val isSelected: Boolean,
        val isEnabled: Boolean = true,
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class DividerComponent(
        val thickness: Int = 1,
        val direction: Direction = Direction.HORIZONTAL,
        val color: String = "#000000",
        override val id: String
    ) : UIComponent()

    @JsonClass(generateAdapter = true)
    data class SpacerComponent(
        val height: Int = 16,
        override val id: String
    ) : UIComponent()

    data object Unknown : UIComponent() {
        override val id: String = "unknown"
    }
}
