package com.dagger.inject

import com.activity.module.LoginViewModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import fieldx.mobile.com.atiyaherb.BaseActivity
import fieldx.mobile.com.atiyaherb.MainActivity

@Module
abstract class ATHActivityModule {

    @ContributesAndroidInjector
    abstract fun bindBaseView(): BaseActivity
    @ContributesAndroidInjector(modules = arrayOf(LoginViewModule::class))
    abstract fun bindMainView():MainActivity
}