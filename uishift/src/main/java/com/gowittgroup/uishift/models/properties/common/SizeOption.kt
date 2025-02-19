package com.gowittgroup.uishift.models.properties.common


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
sealed class SizeOption {
    @JsonClass(generateAdapter = false)
    data object FillMaxSpace : SizeOption()

    @JsonClass(generateAdapter = false)
    data object WrapContent : SizeOption()

    @JsonClass(generateAdapter = false)
    data class Fixed(val value: Int? = null) : SizeOption()
}