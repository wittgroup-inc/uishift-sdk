package com.gowittgroup.uishift.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import com.gowittgroup.uishift.models.properties.VisualTransformation

typealias NativeVisualTransformation = androidx.compose.ui.text.input.VisualTransformation

fun VisualTransformation.toComposeTransformation(): NativeVisualTransformation {
    return when (this) {
        VisualTransformation.NONE -> NativeVisualTransformation.None
        VisualTransformation.PASSWORD -> PasswordVisualTransformation()
        VisualTransformation.CAPITALIZE -> UppercaseVisualTransformation()
    }
}

class UppercaseVisualTransformation : NativeVisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(AnnotatedString(text.text.uppercase()), OffsetMapping.Identity)
    }
}