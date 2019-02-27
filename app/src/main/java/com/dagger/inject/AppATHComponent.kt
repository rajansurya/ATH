package com.dagger.inject

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import fieldx.mobile.com.atiyaherb.AndroidApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,AppATHModule::class, ATHActivityModule::class))
interface AppATHComponent {

    fun injectAppcationContext(application: AndroidApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationATH(application: Application): Builder

        fun buildATH(): AppATHComponent
    }
}