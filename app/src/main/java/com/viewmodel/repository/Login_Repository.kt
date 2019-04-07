package com.viewmodel.repository

import com.data.model.RegistrationData
import com.data.model.Restration_response
import retrofit2.Call

interface Login_Repository {
    fun getLoginResponse(registration: RegistrationData): Call<Restration_response>
    fun getOTPResponse(url:String):Call<Any>
}