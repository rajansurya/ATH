package com.activity.module

import android.arch.lifecycle.ViewModel
import com.viewmodel.repository.Login_Repository
import dagger.Module
import javax.inject.Inject


@Module
class User_verification_Module @Inject constructor(var login_repository: Login_Repository) : ViewModel(){
    fun sendOTPToMobile(url:String) = login_repository.getOTPResponse(url)
}