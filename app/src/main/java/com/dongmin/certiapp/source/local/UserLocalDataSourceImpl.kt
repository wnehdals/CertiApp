package com.dongmin.certiapp.source.local

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.model.StoreInfo
import com.dongmin.certiapp.source.UserDataSource
import io.reactivex.rxjava3.core.Single

class UserLocalDataSourceImpl : UserDataSource {
    override suspend fun getCertiList(serviceKey: String): ResCertification {
        TODO("Not yet implemented")
    }

    override fun getMask(): Single<StoreInfo> {
        TODO("Not yet implemented")
    }

}