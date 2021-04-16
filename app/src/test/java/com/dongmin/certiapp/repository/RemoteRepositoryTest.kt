package com.dongmin.certiapp.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dongmin.certiapp.BaseTest
import com.dongmin.certiapp.api.CertiApi
import com.dongmin.certiapp.configureTestAppComponent
import com.dongmin.certiapp.source.local.UserLocalDataSourceImpl
import com.dongmin.certiapp.source.remote.UserRemoteDataSourceImpl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.test.inject

@RunWith(JUnit4::class)
class RemoteRepositoryTest : BaseTest(){
    private lateinit var repository: UserRepository
    val certiApi: CertiApi by inject()
    val userRemoteDataSource: UserRemoteDataSourceImpl by inject()
    val userLocalDataSource: UserLocalDataSourceImpl by inject()
    val mockWebServer: MockWebServer by inject()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun start(){
        super.setUp()
        startKoin { modules(configureTestAppComponent(getMockWebServerUrl())) }
    }
    @Test
    fun test(){
        mockWebServer.enqueue(MockResponse().setHeader("resultCode","00"))
        repository = UserRepository(userLocalDataSource, userRemoteDataSource)
        val code = repository.getCertiList("mjcDOZkT0XqWULC1L3PAFfxCere4Wq1oXpTJv6jmdF5RmBMPaN6A6Ju112m74zBmsXVsYDW7YJOCH40Q4nmDwg==")
        Assert.assertEquals("00", code.)
    }


}