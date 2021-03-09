package com.dongmin.certiapp.data

import com.google.gson.annotations.SerializedName


data class ResCertification(
    @SerializedName("response") val resCertification: ResponseX
){

}
data class ResponseX(
    @SerializedName("body") val body: Body,
    @SerializedName("header") val header: Header
)

