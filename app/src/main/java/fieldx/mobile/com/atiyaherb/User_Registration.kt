package fieldx.mobile.com.atiyaherb

import android.os.Bundle
import com.activity.module.LoginViewModule
import javax.inject.Inject

class User_Registration : BaseActivity() {
    @Inject
    lateinit var registrationAPI: LoginViewModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_registration)

        registrationAPI.returnBackToView()
    }
}