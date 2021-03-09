package com.dongmin.certiapp.data

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("response")
    val response: ResponseX
)