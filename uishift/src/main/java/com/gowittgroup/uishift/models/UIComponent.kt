package com.gowittgroup.uishift.models

import com.squareup.moshi.JsonClass

sealed class UIComponent {
    abstract val id: String
    abstract val padding: Padding
    abstract val margin: Margin
    abstract val background: Background?
    abstract val shape: Shape?
    abstract val visibility: Visibility
    abstract val alignment: Alignment
    abstract val animation: Animation?
    abstract val interactions: Interactions
    abstract val accessibility: Accessibility?
    abstract val width: Int? // Add width
    abstract val height: Int? // Add height

    abstract class BaseComponent : UIComponent() {
        override val padding: Padding = Padding()
        override val margin: Margin = Margin()
        override val background: Background? = null
        override val shape: Shape? = null
        override val visibility: Visibility = Visibility.VISIBLE
        override val alignment: Alignment = Alignment.START
        override val animation: Animation? = null
        override val interactions: Interactions = Interactions()
        override val accessibility: Accessibility? = null
        override val width: Int? = null
        override val height: Int? = null
    }

    @JsonClass(generateAdapter = true)
    data class TextComponent(
        val content: String,
        val style: String,
        val visualTransformation: VisualTransformation = VisualTransformation.NONE,
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class ButtonComponent(
        val label: String,
        val style: String,
        val onClickAction: ActionFlow,
        val isEnabled: Boolean = true,
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class ImageComponent(
        val url: String,
        val description: String,
        val scaleType: ScaleType = ScaleType.FIT,
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class ColumnComponent(
        val children: List<UIComponent>,
        val isScrollable: Boolean = false,
        val childArrangement: ChildArrangement = ChildArrangement(),
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class RowComponent(
        val children: List<UIComponent>,
        val isScrollable: Boolean = false,
        val childArrangement: ChildArrangement = ChildArrangement(),
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class TextFieldComponent(
        val label: String,
        val hint: String,
        val initialValue: String = "",
        val isEnabled: Boolean = true,
        val readOnly: Boolean = false,
        val validation: Validation = Validation.None(),
        val imeAction: ImeAction = ImeAction.DONE,
        val keyboardType: KeyboardType = KeyboardType.TEXT,
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class RadioButtonComponent(
        val label: String,
        val isSelected: Boolean,
        val isEnabled: Boolean = true,
        val validation: Validation = Validation.None(),
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class CheckBoxComponent(
        val label: String,
        val isChecked: Boolean = false,
        val isEnabled: Boolean = true,
        val validation: Validation = Validation.None(),
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class SliderComponent(
        val min: Float,
        val max: Float,
        val initialValue: Float,
        val isEnabled: Boolean = true,
        val validation: Validation = Validation.None(),
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class SwitchComponent(
        val label: String,
        val isChecked: Boolean,
        val isEnabled: Boolean = true,
        val validation: Validation = Validation.None(),
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class DividerComponent(
        val thickness: Int = 1,
        val direction: Direction = Direction.HORIZONTAL,
        val color: String = "#000000",
        override val id: String
    ) : BaseComponent()

    @JsonClass(generateAdapter = true)
    data class SpacerComponent(
        override val id: String
    ) : BaseComponent()

    data object Unknown : BaseComponent() {
        override val id: String = "unknown"
    }
}