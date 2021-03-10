package com.dongmin.certiapp.module

import com.dongmin.certiapp.repository.UserRepository
import com.dongmin.certiapp.source.local.UserLocalDataSourceImpl
import com.dongmin.certiapp.source.remote.UserRemoteDataSourceImpl
import org.koin.dsl.module

val RepositoryModule = module {
    single { UserRepository(get() as UserLocalDataSourceImpl, get() as UserRemoteDataSourceImpl) }
}