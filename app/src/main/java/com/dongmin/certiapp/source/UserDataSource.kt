package com.dongmin.certiapp.source

import com.dongmin.certiapp.data.ResCertification
import com.dongmin.certiapp.data.festival.ResFestival
import com.dongmin.certiapp.model.StoreInfo
import io.reactivex.rxjava3.core.Single

interface UserDataSource {
    fun getCertiList(serviceKey: String): Single<ResCertification>
    fun getMask() : Single<StoreInfo>
    fun getFestivalList(serviceKey: String, nextPageNumber: Int): Single<ResFestival>
}