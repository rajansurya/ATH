package com.service.imp

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptorOTP(var requestHeaders: RequestHeaders) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        println("Tokenkey XJXJXJXJ ")
        val newrequest: Request = request.newBuilder().addHeader("Content-Type", "text/plain").build()


        return chain.proceed(newrequest)
    }

}