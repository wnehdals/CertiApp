package com.dongmin.certiapp.api

import com.dongmin.certiapp.data.ResCertification
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CertiApi {
    @GET("getList")
    suspend fun getCertiList(
        @Query("serviceKey") serviceKey: String,
        @Query("_type") _type: String = "json"
    ): ResCertification

}