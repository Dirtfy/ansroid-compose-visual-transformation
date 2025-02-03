package com.dirtfy.visualtransformation.currency

import com.dirtfy.visualtransformation.Formater

object CurrencyFormater: Formater {

    override fun format(origin: String): String {
        val reversed = origin.reversed()

        val formated = StringBuilder()

        for (i in reversed.indices) {
            formated.append(reversed[i])

            if ((i + 1) % 3 == 0) {
                formated.append(',')
            }
        }

        val raw = formated.toString().reversed()

        return raw.trimStart(',')
    }

}