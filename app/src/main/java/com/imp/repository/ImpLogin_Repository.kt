package com.imp.repository

import com.viewmodel.repository.Login_Repository
import retrofit2.Call
import javax.inject.Inject
import com.service.imp.Login_Service

class ImpLogin_Repository @Inject constructor(var apicall : Login_Service) : Login_Repository {
    override fun getLoginResponse(): Call<Any> {
        return apicall.loginData()
    }

}