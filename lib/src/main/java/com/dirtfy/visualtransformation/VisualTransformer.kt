package com.dirtfy.visualtransformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

abstract class VisualTransformer: VisualTransformation {
    protected var original = ""

    protected abstract val formater: Formater
    protected val transformed get() = formater.format(original)

    protected abstract val offsetMapping: OffsetMapping

    override fun filter(text: AnnotatedString): TransformedText {
        original = text.text

        return TransformedText(
            AnnotatedString(text = transformed),
            offsetMapping
        )
    }
}