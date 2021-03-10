package com.dongmin.certiapp

import android.app.Application
import android.content.Context
import com.dongmin.certiapp.api.Api
import com.dongmin.certiapp.api.ApiClient
import com.dongmin.certiapp.api.MaskApi
import com.dongmin.certiapp.constant.CERTI_BASE_URL
import com.dongmin.certiapp.constant.MASK_BASE_URL
import com.dongmin.certiapp.repository.UserRepository
import com.dongmin.certiapp.source.UserDataSource
import com.dongmin.certiapp.source.local.UserLocalDataSourceImpl
import com.dongmin.certiapp.source.remote.UserRemoteDataSourceImpl

class CertiApplication : Application() {
    lateinit var userRepository: UserRepository
    private lateinit var localDataSource: UserDataSource
    private lateinit var remoteDataSource: UserDataSource
    private lateinit var apiInterface: Api
    private lateinit var maskInterface: MaskApi
    override fun onCreate() {
        super.onCreate()
        Companion.applicationContext = this
        inject()
        userRepo = userRepository

    }
    private fun inject(){
        apiInterface = ApiClient.getApiClinet(CERTI_BASE_URL).create(Api::class.java)
        maskInterface = ApiClient.getApiClinet(MASK_BASE_URL).create(MaskApi::class.java)
        localDataSource = UserLocalDataSourceImpl()
        remoteDataSource = UserRemoteDataSourceImpl(apiInterface,maskInterface)
        userRepository = UserRepository(localDataSource, remoteDataSource)
    }


    companion object {
        private var applicationContext: Context? = null
        var userRepo: UserRepository? = null
        val dataApiKey: String
            get() = applicationContext!!.resources.getString(R.string.data_api_key)
    }
}
