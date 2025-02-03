package com.dirtfy.visualtransformation.phonenumber

import androidx.compose.ui.text.input.OffsetMapping
import com.dirtfy.visualtransformation.Formater
import com.dirtfy.visualtransformation.VisualTransformer

/**
 * It puts some dashes in string of number.
 *
 * For example:
 * ```
 * 01012341234 -> 010-1234-1234
 * ```
 *
 * CAUTION: It assumes korean area codes and 010 only.
 *
 * @see PhoneNumberFormater
 */
class PhoneNumberVisualTransformation: VisualTransformer() {

    override val formater: Formater = PhoneNumberFormater

    override val offsetMapping: OffsetMapping = object: OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            var transformedOffset = 0
            var originalCount = 0

            for (element in transformed) {
                if (originalCount == offset) break
                transformedOffset++
                if (element != '-') originalCount++
            }
            return transformedOffset
        }

        override fun transformedToOriginal(offset: Int): Int {
            var originalOffset = 0

            for (i in (0 until offset)) {
                if (i < transformed.length && transformed[i] != '-') {
                    originalOffset++
                }
            }
            return originalOffset
        }
    }

}