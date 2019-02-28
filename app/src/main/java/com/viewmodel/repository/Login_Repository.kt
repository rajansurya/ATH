package com.viewmodel.repository

import retrofit2.Call

interface Login_Repository {
    fun getLoginResponse(): Call<Any>
}