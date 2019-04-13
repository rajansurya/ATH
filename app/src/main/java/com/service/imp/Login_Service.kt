package com.service.imp

import com.dagger.inject.NamedClone
import com.dagger.inject.TrackerType
import com.data.model.RegistrationData
import com.data.model.Restration_response
import com.retro.api.APICall
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class Login_Service @Inject constructor(@NamedClone(TrackerType.POST) var retrofit: Retrofit, @NamedClone(TrackerType.GET) var retrofitGet: Retrofit) : APICall {
    //, @NamedClone(TrackerType.GET) var retrofitGet: Retrofit

    override fun otpGet(url: String): Call<Any> {
        return retrofitGet.create(APICall::class.java).otpGet(url)
    }

    override fun loginData(registration: RegistrationData): Call<Restration_response> {
        return retrofit.create(APICall::class.java).loginData(registration)
    }

}