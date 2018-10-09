package com.app.telegraph.di.module

import com.app.telegraph.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class HomeModule {

    @Provides
    fun providesMainPresenter() = MainPresenter()


}