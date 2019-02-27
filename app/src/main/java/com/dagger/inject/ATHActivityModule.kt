package com.dagger.inject

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fieldx.mobile.com.atiyaherb.BaseActivity
import fieldx.mobile.com.atiyaherb.MainActivity

@Module
abstract class ATHActivityModule {

    @ContributesAndroidInjector
    abstract fun bindBaseView(): BaseActivity
    @ContributesAndroidInjector
    abstract fun bindMainView():MainActivity
}