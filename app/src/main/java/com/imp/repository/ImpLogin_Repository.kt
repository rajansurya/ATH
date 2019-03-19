package com.imp.repository

import android.util.Log
import com.google.gson.Gson
import com.service.imp.Login_Service
import com.viewmodel.repository.Login_Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ImpLogin_Repository @Inject constructor(var apicall: Login_Service) : Login_Repository {
    override fun getLoginResponse(): Call<Any> {
        val ob: Call<Any> = apicall.loginData()
        ob.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>?, t: Throwable?) {
                Log.i("Response   onFailure ", t?.stackTrace.toString());
            }

            override fun onResponse(call: Call<Any>?, response: Response<Any>) {
                if (response.isSuccessful) {
                    Log.i(" RAJAN KODARE  ", Gson().toJson(response?.body()));
                } else {
                    Log.i(" RAJAN KODARE  ", response.errorBody().toString());
                }
            }

        })
        return apicall.loginData()

    }

}