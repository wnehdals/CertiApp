package com.dongmin.certiapp.data.festival

import com.dongmin.certiapp.data.Items
import com.google.gson.annotations.SerializedName

data class FestivalBody(
    @SerializedName("items")
    val items: FestivalItems,
    @SerializedName("pageNo")
    val pageNo: Int,
    @SerializedName("totalCount")
    val totalCount: Int

)