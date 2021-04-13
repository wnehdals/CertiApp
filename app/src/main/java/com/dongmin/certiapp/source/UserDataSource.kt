package com.dongmin.certiapp.source

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.model.StoreInfo
import io.reactivex.rxjava3.core.Single

interface UserDataSource {
    suspend fun getCertiList(serviceKey: String): ResCertification
    fun getMask() : Single<StoreInfo>
}