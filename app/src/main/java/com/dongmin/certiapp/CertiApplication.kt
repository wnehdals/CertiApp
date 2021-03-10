package com.dongmin.certiapp

import android.app.Application
import android.content.Context
import com.dongmin.certiapp.api.CertiApi
import com.dongmin.certiapp.api.MaskApi
import com.dongmin.certiapp.module.DataSourceModule
import com.dongmin.certiapp.module.NetWorkModule
import com.dongmin.certiapp.module.RepositoryModule
import com.dongmin.certiapp.module.ViewModelModule
import com.dongmin.certiapp.repository.UserRepository
import com.dongmin.certiapp.source.UserDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CertiApplication : Application() {
    lateinit var userRepository: UserRepository
    private lateinit var localDataSource: UserDataSource
    private lateinit var remoteDataSource: UserDataSource
    private lateinit var apiInterface: CertiApi
    private lateinit var maskInterface: MaskApi
    override fun onCreate() {
        super.onCreate()
        Companion.applicationContext = this
        startKoin {
            androidLogger()
            androidContext(this@CertiApplication)
            modules(DataSourceModule)
            modules(NetWorkModule)
            modules(RepositoryModule)
            modules(ViewModelModule)
        }
        //inject()
        //userRepo = userRepository

    }
    /*
    private fun inject(){
        apiInterface = ApiClient.getApiClinet(CERTI_BASE_URL).create(CertiApi::class.java)
        maskInterface = ApiClient.getApiClinet(MASK_BASE_URL).create(MaskApi::class.java)
        localDataSource = UserLocalDataSourceImpl()
        remoteDataSource = UserRemoteDataSourceImpl(apiInterface,maskInterface)
        userRepository = UserRepository(localDataSource, remoteDataSource)
    }


     */

    companion object {
        private var applicationContext: Context? = null
        var userRepo: UserRepository? = null
        val dataApiKey: String
            get() = applicationContext!!.resources.getString(R.string.data_api_key)
    }
}
