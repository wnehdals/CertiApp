package com.dongmin.certiapp.data.festival

import com.google.gson.annotations.SerializedName

data class FestivalItem(
    @SerializedName("addr1") val addr1: String,
    @SerializedName("areacode") val areacode: String,
    @SerializedName("contentid") val contentid: String,
    @SerializedName("firstimage") val firstimage: String,
    @SerializedName("title") val title: String,
)