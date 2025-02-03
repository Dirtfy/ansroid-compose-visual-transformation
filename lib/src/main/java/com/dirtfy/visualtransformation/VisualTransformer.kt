package com.dirtfy.visualtransformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

/**
 * It's parent class for all implementation of visual transformation in this library.
 *
 * It works like a framework for implementation of VisualTransformation.
 *
 * @property original actual data that has been typing
 * @property formater provide format function by [Formater.format]
 * @property transformed literally transformed text from origin by format function
 * @property offsetMapping requirement for implementation of VisualTransformation
 *
 * @see Formater
 * @see VisualTransformation
 *
 */
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