package com.gowittgroup.uishift.models.properties

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import com.squareup.moshi.Json

typealias ComposeVisualTransformation = androidx.compose.ui.text.input.VisualTransformation

enum class VisualTransformation {
    @Json(name = "none") NONE,
    @Json(name = "password") PASSWORD,
    @Json(name = "capitalize") CAPITALIZE
}

fun VisualTransformation.toComposeTransformation(): ComposeVisualTransformation {
    return when (this) {
        VisualTransformation.NONE -> ComposeVisualTransformation.None
        VisualTransformation.PASSWORD -> PasswordVisualTransformation()
        VisualTransformation.CAPITALIZE -> UppercaseVisualTransformation()
    }
}

class UppercaseVisualTransformation : ComposeVisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(AnnotatedString(text.text.uppercase()), OffsetMapping.Identity)
    }
}