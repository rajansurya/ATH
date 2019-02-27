package com.dagger.inject

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppATHModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}