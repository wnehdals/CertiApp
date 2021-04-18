package com.dongmin.certiapp.source.local

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.data.festival.ResFestival
import com.dongmin.certiapp.model.StoreInfo
import com.dongmin.certiapp.source.UserDataSource
import io.reactivex.rxjava3.core.Single

class UserLocalDataSourceImpl : UserDataSource {
    override fun getCertiList(serviceKey: String): Single<ResCertification> {
        TODO("Not yet implemented")
    }

    override fun getMask(): Single<StoreInfo> {
        TODO("Not yet implemented")
    }

    override fun getFestivalList(serviceKey: String, nextPageNumber: Int): Single<ResFestival> {
        TODO("Not yet implemented")
    }
}