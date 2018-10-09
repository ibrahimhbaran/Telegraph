package com.app.telegraph.di.component

import com.app.telegraph.TelegraphApp
import com.app.telegraph.di.module.ApplicationModule
import com.app.telegraph.di.module.HomeModule
import com.app.telegraph.di.module.NetworkAPIModule
import com.app.telegraph.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class),(HomeModule::class),(NetworkAPIModule::class)])
interface ApplicationComponent {

    fun inject(application: TelegraphApp)
    fun inject(activity: MainActivity)

}