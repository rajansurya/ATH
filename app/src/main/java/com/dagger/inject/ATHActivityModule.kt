package com.dagger.inject

import com.activity.module.LoginViewModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import fieldx.mobile.com.atiyaherb.BaseActivity
import fieldx.mobile.com.atiyaherb.DiseasesView
import fieldx.mobile.com.atiyaherb.MainActivity
import fieldx.mobile.com.atiyaherb.User_Registration

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
}