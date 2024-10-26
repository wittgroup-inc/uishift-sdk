package com.gowittgroup.uishift.parser

import com.gowittgroup.uishift.constants.SizeOptionToken
import com.gowittgroup.uishift.models.properties.common.SizeOption
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

class SizeOptionAdapter {

    @ToJson
    fun toJson(sizeOption: SizeOption): Any? {
        return when (sizeOption) {
             SizeOption.FillMaxSpace -> SizeOptionToken.FILL_MAX_SPACE
             SizeOption.WrapContent -> SizeOptionToken.WRAP_CONTENT
            is SizeOption.Fixed -> sizeOption.value
        }
    }

    @FromJson
    fun fromJson(value: Any): SizeOption {
        return when (value) {
            is String -> when (value) {
                SizeOptionToken.FILL_MAX_SPACE -> SizeOption.FillMaxSpace
                SizeOptionToken.WRAP_CONTENT -> SizeOption.WrapContent
                else -> throw JsonDataException("Unknown SizeOption type: $value")
            }
            is Int -> SizeOption.Fixed(value)
            else -> throw JsonDataException("Invalid type for SizeOption: $value")
        }
    }
}
