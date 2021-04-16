package com.dongmin.certiapp.module

import com.dongmin.certiapp.constant.CERTI
import com.dongmin.certiapp.constant.MASK
import com.dongmin.certiapp.source.local.UserLocalDataSourceImpl
import com.dongmin.certiapp.source.remote.UserRemoteDataSourceImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val DataSourceModule = module {
    single { UserRemoteDataSourceImpl(get(named(CERTI)), get(named(MASK))) }
    single { UserLocalDataSourceImpl() }
}