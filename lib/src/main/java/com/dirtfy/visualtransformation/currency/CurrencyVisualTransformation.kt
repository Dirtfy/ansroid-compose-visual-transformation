package com.dirtfy.visualtransformation.currency

import androidx.compose.ui.text.input.OffsetMapping
import com.dirtfy.visualtransformation.Formater
import com.dirtfy.visualtransformation.VisualTransformer
import kotlin.math.abs
import kotlin.math.max

/**
 * It puts some commas in string of number.
 *
 * For example: 1234567 -> 1,234,567
 *
 * @see CurrencyFormater
 */
class CurrencyVisualTransformation: VisualTransformer() {

    override val formater: Formater = CurrencyFormater

    override val offsetMapping = object: OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            // 문자열 젤 뒤를 offset 0으로 offset 거꾸로 세기
            val offsetComp = original.length - offset

            val remainComma = max((offsetComp + 2) / 3 - 1, 0)
            val totalComma = abs(original.length - transformed.length)
            val passedComma = totalComma - remainComma

            return offset + passedComma
        }

        override fun transformedToOriginal(offset: Int): Int {
            var originalOffset = 0

            for (i in 0..< offset) {
                if (transformed[i] == ',')
                    continue
                originalOffset++
            }

            return originalOffset
        }

    }

}
