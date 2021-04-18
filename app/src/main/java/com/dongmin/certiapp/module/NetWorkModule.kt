package com.dongmin.certiapp.module

import com.dongmin.certiapp.api.CertiApi
import com.dongmin.certiapp.api.FestivalApi
import com.dongmin.certiapp.api.MaskApi
import com.dongmin.certiapp.constant.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

val NetWorkModule = module {
    single(named(MASK)){
        Retrofit.Builder()
            .baseUrl(MASK_BASE_URL)
            .client(provideLogging())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single(named(CERTI)){
        Retrofit.Builder()
            .baseUrl(CERTI_BASE_URL)
            .client(provideLogging())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single(named(FESTIVAL)){
        Retrofit.Builder()
            .baseUrl(FESTIVAL_BASE_URL)
            .client(provideLogging())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single<GsonConverterFactory> { GsonConverterFactory.create()}

    single(named(MASK)){
        provideMaskApi(get(named(MASK)))
    }
    single(named(CERTI)){
        provideCertiApi(get(named(CERTI)))
    }
    single(named(FESTIVAL)){
        provideFestivalApi(get(named(FESTIVAL)))
    }
}
fun provideMaskApi(retrofit: Retrofit): MaskApi = retrofit.create(MaskApi::class.java)
fun provideCertiApi(retrofit: Retrofit): CertiApi = retrofit.create(CertiApi::class.java)
fun provideFestivalApi(retrofit: Retrofit): FestivalApi = retrofit.create(FestivalApi::class.java)

fun provideLogging(): OkHttpClient {
    var logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        //.writeTimeout(2000, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .build();

}
