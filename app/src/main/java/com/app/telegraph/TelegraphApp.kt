package com.app.telegraph

import android.app.Application
import com.app.telegraph.di.component.ApplicationComponent
import com.app.telegraph.di.component.DaggerApplicationComponent
import com.app.telegraph.di.module.ApplicationModule
import com.app.telegraph.di.module.HomeModule
import com.app.telegraph.di.module.NetworkAPIModule


class TelegraphApp : Application() {

    val component: ApplicationComponent by lazy {

        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .homeModule(HomeModule())
                .networkAPIModule(NetworkAPIModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}