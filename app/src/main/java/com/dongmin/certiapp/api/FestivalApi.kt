package com.dongmin.certiapp.api

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.data.festival.ResFestival
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FestivalApi {
    @GET("areaBasedList")
    suspend fun getFestivalList(
        @Query("serviceKey") serviceKey: String,
        @Query("contentTypeId") contentTypeId: String = "15",
        @Query("listYN") listYN: String = "Y",
        @Query("MobileOS") MobileOS: String = "AND",
        @Query("MobileApp") MobileApp: String = "CertiApp",
        @Query("arrange") arrange: String = "A",
        @Query("numOfRows") numOfRows: String = "20",
        @Query("pageNo") pageNo: Int,
        @Query("_type") _type: String = "json"
    ): ResFestival

}