package com.dongmin.certiapp.repository

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.data.ResponseX
import com.dongmin.certiapp.model.StoreInfo
import com.dongmin.certiapp.source.local.UserLocalDataSource
import com.dongmin.certiapp.source.remote.UserRemoteDataSource
import io.reactivex.rxjava3.core.Single

class UserRepository(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRemoteDataSource, UserLocalDataSource{
    override fun getCertiList(serviceKey: String): Single<ResCertification> {
        return userRemoteDataSource.getCertiList(serviceKey = serviceKey)
    }

    override fun getMask(): Single<StoreInfo> {
        return userRemoteDataSource.getMask()
    }
}