package com.dongmin.certiapp.data

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("item")
    val item: ArrayList<Item>
)