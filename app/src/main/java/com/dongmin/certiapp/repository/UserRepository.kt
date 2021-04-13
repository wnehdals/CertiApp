package com.dongmin.certiapp.repository

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.model.StoreInfo
import com.dongmin.certiapp.source.UserDataSource
import io.reactivex.rxjava3.core.Single
import org.koin.core.component.KoinComponent

class UserRepository(
    private val userLocalDataSource: UserDataSource,
    private val userRemoteDataSource: UserDataSource
) : UserDataSource{
    override suspend fun getCertiList(serviceKey: String): ResCertification {
        return userRemoteDataSource.getCertiList(serviceKey = serviceKey)
    }

    override fun getMask(): Single<StoreInfo> {
        return userRemoteDataSource.getMask()
    }
}