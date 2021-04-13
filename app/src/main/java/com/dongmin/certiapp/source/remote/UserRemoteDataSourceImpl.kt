package com.dongmin.certiapp.source.remote

import com.dongmin.certiapp.api.CertiApi
import com.dongmin.certiapp.api.MaskApi
import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.model.StoreInfo
import com.dongmin.certiapp.source.UserDataSource
import io.reactivex.rxjava3.core.Single

class UserRemoteDataSourceImpl(
    private val CertiApi: CertiApi,
    private val maskApi: MaskApi
) : UserDataSource {
    override suspend fun getCertiList(serviceKey: String): ResCertification {
        return CertiApi.getCertiList(serviceKey = serviceKey)
    }

    override fun getMask(): Single<StoreInfo> {
        return maskApi.fetchStoreInfo()
    }
}