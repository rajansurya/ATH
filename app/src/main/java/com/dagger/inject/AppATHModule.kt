package com.dagger.inject

import android.app.Application
import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.imp.repository.ImpLogin_Repository
import com.service.imp.RequestHeaders
import com.service.imp.RequestInterceptor
import com.viewmodel.repository.Login_Repository
import dagger.Module
import dagger.Provides
import fieldx.mobile.com.atiyaherb.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppATHModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideRequestHeader(): RequestHeaders {
        return RequestHeaders("YWlvczE5MzA6YWlvczE5MzBhaW9z")
    }

    @Provides
    @Singleton
    fun providesRequestInterceptor(requestHeaders: RequestHeaders): RequestInterceptor {
        return RequestInterceptor(requestHeaders)
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, requestInterceptor: RequestInterceptor, okHttpClientBuilder: OkHttpClient.Builder): Retrofit {

        //add logger
        val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        okHttpClientBuilder.addInterceptor(logging);
        okHttpClientBuilder.addInterceptor(requestInterceptor)
        val okhttpclient: OkHttpClient = okHttpClientBuilder.build()

        val retrofit: Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(BuildConfig.BASE_URL).client(okhttpclient).build()
        return retrofit
    }

    @Singleton
    @Provides
    fun provideLogin_Repository(implogin_rep: ImpLogin_Repository): Login_Repository {
        return implogin_rep
    }
}