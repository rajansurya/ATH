package com.dagger.inject

import com.activity.module.LoginViewModule
import com.activity.module.User_verification_Module
import dagger.Module
import dagger.android.ContributesAndroidInjector
import fieldx.mobile.com.atiyaherb.*

@Module
abstract class ATHActivityModule {

    @ContributesAndroidInjector
    abstract fun bindBaseView(): BaseActivity

    @ContributesAndroidInjector(modules = arrayOf(LoginViewModule::class))
    abstract fun bindMainView(): User_Health_Info

    @ContributesAndroidInjector
    abstract fun bindDiseasesView(): DiseasesView

    @ContributesAndroidInjector(modules = arrayOf(LoginViewModule::class))
    abstract fun bindUser_Registration(): User_Registration

    @ContributesAndroidInjector
    abstract fun bindinfo(): InfoPage

    @ContributesAndroidInjector
    abstract fun bindsplash(): Splash

    @ContributesAndroidInjector(modules = arrayOf(User_verification_Module::class))
    abstract fun bindUserverify():UserVarify
}