package com.dongmin.certiapp.source.remote

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.data.ResponseX
import com.dongmin.certiapp.model.StoreInfo
import io.reactivex.rxjava3.core.Single

interface UserRemoteDataSource {
    fun getCertiList(serviceKey: String): Single<ResCertification>
    fun getMask() :Single<StoreInfo>
}