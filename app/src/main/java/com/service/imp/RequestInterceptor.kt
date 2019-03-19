package com.service.imp

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor(var requestHeaders: RequestHeaders) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        println("Tokenkey"+ requestHeaders.tokenKey)
        val newrequest: Request = request.newBuilder().addHeader("Tokenkey", requestHeaders.tokenKey).addHeader("Content-Type", "application/json").build()
        return chain.proceed(newrequest)
    }

}