package com.service.imp

import com.data.model.RegistrationData
import com.retro.api.APICall
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class Login_Service @Inject constructor(var retrofit: Retrofit) : APICall {

    override fun loginData(registration: RegistrationData): Call<Any> {
        return retrofit.create(APICall::class.java).loginData(registration)
    }

}