package com.app.telegraph.di.module

import com.app.telegraph.TelegraphApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val telegraphApp: TelegraphApp) {

    @Provides
    @Singleton
    fun provideApp() = telegraphApp

}
