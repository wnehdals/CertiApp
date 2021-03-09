package com.dongmin.certiapp.api

import com.dongmin.certiapp.model.StoreInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MaskApi {
    @GET("sample.json")
    fun fetchStoreInfo(): Single<StoreInfo>


}