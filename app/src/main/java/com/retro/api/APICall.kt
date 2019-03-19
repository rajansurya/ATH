package com.retro.api

import com.data.model.RegistrationData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APICall {
    @POST("/hsk/beta/registration-api.php")
    fun loginData(@Body registration: RegistrationData): Call<Any>
}