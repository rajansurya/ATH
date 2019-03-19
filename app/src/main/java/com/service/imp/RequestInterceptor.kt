package com.service.imp

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor(var requestHeaders: RequestHeaders) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val requestBuilder: Request.Builder = request.newBuilder().header("Tokenkey", requestHeaders.tokenKey)
        val newrequest = requestBuilder.build()
        return chain.proceed(newrequest)
    }

}