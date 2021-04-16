package com.dongmin.certiapp
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

abstract class BaseTest : KoinTest{

    private lateinit var mockWebServer: MockWebServer
    private var shouldStart = false
    @Before
    open fun setUp(){
        startMockServer(true)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @After
    open fun tearDown(){
        stopMockServer()
        stopKoin()
    }

    private fun startMockServer(_shouldStart:Boolean){
        if (_shouldStart){
            shouldStart = _shouldStart
            mockWebServer = MockWebServer()
            mockWebServer.start()
        }
    }

    fun getMockWebServerUrl() = mockWebServer.url("/").toString()

    /**
     * Stop Mockwebserver
     */
    private fun stopMockServer() {
        if (shouldStart){
            mockWebServer.shutdown()
        }
    }
}