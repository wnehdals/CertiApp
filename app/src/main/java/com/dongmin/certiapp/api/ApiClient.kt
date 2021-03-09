package com.dongmin.certiapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.log

object ApiClient {

    fun getApiClinet(base_URL: String): Retrofit{
        return Retrofit.Builder()
            .baseUrl(base_URL)
            .client(provideLogging())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    private fun provideLogging(): OkHttpClient{
        var logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient().newBuilder()
            .connectTimeout(1500,TimeUnit.SECONDS)
            .readTimeout(3000,TimeUnit.SECONDS)
            //.writeTimeout(2000, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build();

    }
    private fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder().apply {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(35, TimeUnit.SECONDS)
            addInterceptor(HttpLoggingInterceptor().apply {
                level
                HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }
}