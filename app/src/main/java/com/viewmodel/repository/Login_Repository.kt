package com.viewmodel.repository

import com.data.model.RegistrationData
import retrofit2.Call

interface Login_Repository {
    fun getLoginResponse(registration: RegistrationData): Call<Any>
}