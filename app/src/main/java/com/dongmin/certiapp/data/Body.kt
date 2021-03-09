package com.dongmin.certiapp.data

import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("items")
    val items: Items
)