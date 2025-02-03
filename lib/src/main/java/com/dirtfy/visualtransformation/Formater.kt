package com.dirtfy.visualtransformation

/**
 * Simple interface for providing formating.
 */
interface Formater {

    /**
     * @param origin original string before formating
     * @return formated string
     */
    fun format(origin: String): String
}