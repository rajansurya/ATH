package com.retro.api

import retrofit2.Call
import retrofit2.http.POST

interface APICall {
    @POST("")
    fun loginData(): Call<Any>
}