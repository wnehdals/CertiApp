package com.dongmin.certiapp.data.festival

import com.google.gson.annotations.SerializedName

data class FestivalHeader(
    @SerializedName("resultCode")
    val resultCode: String,
    @SerializedName("resultMsg")
    val resultMsg: String
)