package com.alirahimi.digikalaclone.util

import com.alirahimi.digikalaclone.util.Constants.ENGLISH_LANGUAGE
import com.alirahimi.digikalaclone.util.Constants.USER_LANGUAGE
import java.math.BigDecimal
import java.text.DecimalFormat

object DigitHelper {

    fun digitByLocate(englishString: String): String {

        var result = ""
        var fa = '۰'

        for (character in englishString) {
            fa = character

            when (character) {
                '0' -> fa = '۰'
                '1' -> fa = '۱'
                '2' -> fa = '۲'
                '3' -> fa = '۳'
                '4' -> fa = '۴'
                '5' -> fa = '۵'
                '6' -> fa = '۶'
                '7' -> fa = '۷'
                '8' -> fa = '۸'
                '9' -> fa = '۹'
            }

            result = "${result}$fa"
        }
        return result
    }

    fun digitBySeparator(price: String): String {
        val priceFormat = DecimalFormat("###,###")
        return priceFormat.format(Integer.valueOf(price))
    }

    fun digitByLocateAndSeparator(price: String): String {
        val priceWithoutCommas = price.replace(",", "")
        val persianDigit = digitByLocate(priceWithoutCommas)
        return digitBySeparator(persianDigit)
    }


    fun applyDiscount(price: Long, discountPercent: Int): Long {
        return if (discountPercent > 0) {
            val discountAmount = (price * discountPercent) / 100
            price - discountAmount
        } else {
            price
        }
    }

    fun toomanToDollar(price: Long): String {
        if (USER_LANGUAGE == ENGLISH_LANGUAGE) return (price / 3000L).toString() else return price.toString()
    }

}