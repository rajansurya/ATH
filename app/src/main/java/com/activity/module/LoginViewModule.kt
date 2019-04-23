package com.activity.module

import android.arch.lifecycle.ViewModel
import com.data.model.RegistrationData
import com.viewmodel.repository.Login_Repository
import dagger.Module
import javax.inject.Inject

@Module
class LoginViewModule @Inject constructor(var login_repository: Login_Repository) : ViewModel() {
    fun returnBackToView(registration: RegistrationData) = login_repository.getLoginResponse(registration)
    //fun sendOTPToMobile(url:String) = login_repository.getOTPResponse(url)
}