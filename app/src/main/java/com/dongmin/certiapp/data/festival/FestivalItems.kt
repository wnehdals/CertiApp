package com.dongmin.certiapp.data.festival

import com.google.gson.annotations.SerializedName

data class FestivalItems(
    @SerializedName("item")
    val item: ArrayList<FestivalItem>



)