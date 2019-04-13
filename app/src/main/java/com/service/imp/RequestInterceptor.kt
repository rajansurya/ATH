package com.service.imp

import android.util.Log
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor(var requestHeaders: RequestHeaders) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        println("Tokenkey  "+ requestHeaders.tokenKey)
        val newrequest: Request = request.newBuilder().addHeader("Tokenkey", requestHeaders.tokenKey).addHeader("Content-Type", "application/json").build()
//        val newrequest: Request = request.newBuilder().addHeader("Content-Type", "text/plain").build()

        return chain.proceed(newrequest)
    }

}