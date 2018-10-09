package com.app.telegraph.di.module

import com.app.telegraph.data.source.NetworkApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class NetworkAPIModule {

    @Provides
    @Singleton
    fun provideNetworkApiService() = NetworkApi.create()
}