package com.dongmin.certiapp.source.remote

import com.dongmin.certiapp.api.Api
import com.dongmin.certiapp.api.MaskApi
import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.data.ResponseX
import com.dongmin.certiapp.model.StoreInfo
import com.dongmin.certiapp.source.local.UserLocalDataSource
import io.reactivex.rxjava3.core.Single

class UserRemoteDataSourceImpl(
    private val api: Api,
    private val maskApi: MaskApi
) : UserRemoteDataSource{
    override fun getCertiList(serviceKey: String): Single<ResCertification> {
        return api.getCertiList(serviceKey = serviceKey)
    }

    override fun getMask(): Single<StoreInfo> {
        return maskApi.fetchStoreInfo()
    }
}