package com.dongmin.certiapp

import com.dongmin.certiapp.module.DataSourceModule
import com.dongmin.certiapp.module.NetWorkModule
import com.dongmin.certiapp.module.RepositoryModule
import com.dongmin.certiapp.module.ViewModelModule

fun configureTestAppComponent(baseApi: String)
        = listOf(
    MockWebServerDIPTest,
    configureNetworkModuleForTest(baseApi),
    DataSourceModule,
    RepositoryModule,
    ViewModelModule
)