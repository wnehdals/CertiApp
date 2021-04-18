package com.dongmin.certiapp.data.festival

import com.dongmin.certiapp.data.Body
import com.dongmin.certiapp.data.Header
import com.dongmin.certiapp.data.ResponseX
import com.google.gson.annotations.SerializedName

data class ResFestival (
    @SerializedName("response") val resFestival: ResponseFestival
){

}
data class ResponseFestival(
    @SerializedName("body") val body: FestivalBody,
    @SerializedName("header") val header: FestivalHeader
)
