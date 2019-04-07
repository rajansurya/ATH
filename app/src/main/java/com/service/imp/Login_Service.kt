package com.service.imp

import com.data.model.RegistrationData
import com.data.model.Restration_response
import com.retro.api.APICall
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class Login_Service @Inject constructor(var retrofit: Retrofit) : APICall {
    override fun otpGet(url: String): Call<Any> {
        return retrofit.create(APICall::class.java).otpGet(url)
    }

    override fun loginData(registration: RegistrationData): Call<Restration_response> {
        return retrofit.create(APICall::class.java).loginData(registration)
    }

}