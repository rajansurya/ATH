package com.retro.api

import com.data.model.RegistrationData
import com.data.model.Restration_response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface APICall {
    @POST("/hsk/beta/registration-api.php")
    fun loginData(@Body registration: RegistrationData): Call<Restration_response>

    @GET
    fun otpGet(@Url url: String): Call<Any>
}