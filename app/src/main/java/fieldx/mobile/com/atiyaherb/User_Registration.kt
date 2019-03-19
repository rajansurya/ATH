package fieldx.mobile.com.atiyaherb

import android.os.Bundle
import android.util.Log
import com.activity.module.LoginViewModule
import com.data.model.RegistrationData
import com.data.model.Restration_response
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class User_Registration : BaseActivity() {
    @Inject
    lateinit var registrationAPI: LoginViewModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_registration)

      var call:  Call<Restration_response> =   registrationAPI.returnBackToView( RegistrationData())
        println("FFFFFFFFF"+call)
        call.enqueue(object : Callback<Restration_response> {
            override fun onFailure(call: Call<Restration_response>?, t: Throwable?) {
                Log.i("ResonFailure FFFFFFFFF ", t?.stackTrace.toString());
            }

            override fun onResponse(call: Call<Restration_response>?, response: Response<Restration_response>) {
                if (response.isSuccessful) {
                    Log.i(" FFFFFFFFF KODARE  ", response.body()?.status_msg)//Gson().toJson(response?.body())
                    Log.i(" FFFFFFFFF KODARE  ", response.body()?.status_api)
                } else {
                    Log.i(" FFFFFFFFF KODARE  ", response.errorBody().toString())
                }
            }

        })
    }
}