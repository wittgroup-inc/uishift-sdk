package com.gowittgroup.uishift.models

// Padding and Margin
data class Padding(val top: Int = 0, val bottom: Int = 0, val start: Int = 0, val end: Int = 0)
data class Margin(val top: Int = 0, val bottom: Int = 0, val start: Int = 0, val end: Int = 0)

// Background
data class Background(
    val color: String = "#FFFFFF",  // Default white background
    val gradient: Gradient? = null,
    val image: String? = null  // URL to background image if any
)

data class Gradient(
    val startColor: String,
    val endColor: String,
    val orientation: GradientOrientation = GradientOrientation.VERTICAL
)

enum class GradientOrientation {
    VERTICAL, HORIZONTAL, DIAGONAL
}

// Shape
data class Shape(
    val type: ShapeType = ShapeType.RECTANGLE,
    val cornerRadius: Int = 0,
    val borderColor: String? = null,
    val borderWidth: Int = 0
)

enum class ShapeType {
    RECTANGLE, CIRCLE, ROUNDED_RECTANGLE, OVAL
}

// Visibility
enum class Visibility {
    VISIBLE, INVISIBLE, GONE
}

// Alignment
enum class Alignment {
    START, CENTER, END, TOP, BOTTOM, LEFT, RIGHT
}

// Animation
data class Animation(
    val type: AnimationType,
    val duration: Long = 300L,  // Duration in milliseconds
    val delay: Long = 0L  // Delay before starting animation
)

enum class AnimationType {
    FADE_IN, FADE_OUT, SLIDE_IN, SLIDE_OUT, SCALE, ROTATE
}

// Interactions
data class Interactions(
    val onClick: ActionFlow? = null,
    val onLongPress: ActionFlow? = null,
    val onSwipe: SwipeAction? = null
)

data class SwipeAction(
    val direction: SwipeDirection,
    val action: ActionFlow
)

enum class SwipeDirection {
    LEFT, RIGHT, UP, DOWN
}

// Accessibility
data class Accessibility(
    val description: String? = null,
    val isFocusable: Boolean = true,
    val isClickable: Boolean = false
)

enum class FontWeight {
    NORMAL, BOLD, LIGHT
}

enum class FontStyle {
    NORMAL, ITALIC, OBLIQUE
}

enum class TextAlign {
    START, CENTER, END, JUSTIFY
}

// Visual Transformation
enum class VisualTransformation {
    NONE, PASSWORD, CAPITALIZE
}

// Keyboard Type
enum class KeyboardType {
    TEXT, NUMBER, EMAIL, PHONE, PASSWORD
}

// ImeAction (Keyboard action button type)
enum class ImeAction {
    DONE, GO, NEXT, SEARCH, SEND
}