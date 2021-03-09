package com.dongmin.certiapp.data

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("jmcd") val jmcd: String,
    @SerializedName("jmfldnm") val jmfldnm: String,
    @SerializedName("mdobligfldcd") val mdobligfldcd: String,
    @SerializedName("mdobligfldnm") val mdobligfldnm: String,
    @SerializedName("obligfldcd") val obligfldcd: String,
    @SerializedName("obligfldnm") val obligfldnm: String,
    @SerializedName("qualgbcd") val qualgbcd: String,
    @SerializedName("qualgbnm") val qualgbnm: String,
    @SerializedName("seriescd") val seriescd: String,
    @SerializedName("seriesnm") val seriesnm: String
)