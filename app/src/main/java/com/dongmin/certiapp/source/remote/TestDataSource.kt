package com.dongmin.certiapp.source.remote

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.model.StoreInfo
import com.dongmin.certiapp.source.UserDataSource
import io.reactivex.rxjava3.core.Single

class TestDataSource: UserDataSource {
    override fun getCertiList(serviceKey: String): Single<ResCertification> {
        TODO("Not yet implemented")
    }

    override fun getMask(): Single<StoreInfo> {
        TODO("Not yet implemented")
    }
}