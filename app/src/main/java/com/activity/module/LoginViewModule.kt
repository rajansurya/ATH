package com.activity.module

import com.data.model.RegistrationData
import com.viewmodel.repository.Login_Repository
import dagger.Module
import javax.inject.Inject

@Module
class LoginViewModule @Inject constructor(var login_repository: Login_Repository) {
    fun returnBackToView(registration: RegistrationData) = login_repository.getLoginResponse(registration)
}