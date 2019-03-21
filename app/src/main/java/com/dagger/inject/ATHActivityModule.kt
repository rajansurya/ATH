package com.dagger.inject

import com.activity.module.LoginViewModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import fieldx.mobile.com.atiyaherb.*

@Module
abstract class ATHActivityModule {

    @ContributesAndroidInjector
    abstract fun bindBaseView(): BaseActivity

    @ContributesAndroidInjector(modules = arrayOf(LoginViewModule::class))
    abstract fun bindMainView(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindDiseasesView(): DiseasesView

    @ContributesAndroidInjector(modules = arrayOf(LoginViewModule::class))
    abstract fun bindUser_Registration(): User_Registration

    @ContributesAndroidInjector
    abstract fun bindinfo(): InfoPage

    @ContributesAndroidInjector
    abstract fun bindsplash(): Splash
}