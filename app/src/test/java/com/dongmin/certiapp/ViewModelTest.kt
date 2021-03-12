package com.dongmin.certiapp

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dongmin.certiapp.api.Api
import com.dongmin.certiapp.api.ApiClient
import com.dongmin.certiapp.api.MaskApi
import com.dongmin.certiapp.constant.CERTI_BASE_URL
import com.dongmin.certiapp.constant.MASK_BASE_URL
import com.dongmin.certiapp.data.Item
import com.dongmin.certiapp.repository.UserRepository
import com.dongmin.certiapp.source.local.UserLocalDataSourceImpl
import com.dongmin.certiapp.source.remote.UserRemoteDataSourceImpl
import com.dongmin.certiapp.ui.home.HomeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewModelTest {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var item: Item

    //@get:Rule
    //var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        val apiInterface = ApiClient.getApiClinet(CERTI_BASE_URL).create(Api::class.java)
        val maskInterface = ApiClient.getApiClinet(MASK_BASE_URL).create(MaskApi::class.java)
        val userRemoteDataSource = UserRemoteDataSourceImpl(apiInterface, maskInterface)
        val userLocalDataSource = UserLocalDataSourceImpl()
        val userRepository = UserRepository(userLocalDataSource, userRemoteDataSource)
        homeViewModel = HomeViewModel(userRepository)
    }
    @Test
    fun homeViewModel_isGetData_ReturnTrue(){
        val title = "jmfldnm"
        var a = MutableLiveData<Int>()

        homeViewModel.getCertiList("mjcDOZkT0XqWULC1L3PAFfxCere4Wq1oXpTJv6jmdF5RmBMPaN6A6Ju112m74zBmsXVsYDW7YJOCH40Q4nmDwg==")
        val targetTitle = "가스기술사"
        val realList = homeViewModel.certiList.getOrAwaitValue()

    }
    @Test
    fun homeViewModel_isGetData_ReturnFalse(){
    }

}