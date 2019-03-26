package fieldx.mobile.com.atiyaherb

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.activity.module.LoginViewModule
import com.data.model.RegistrationData
import com.data.model.Restration_response
import fieldx.mobile.com.atiyaherb.databinding.UserRegistrationBinding
import kotlinx.android.synthetic.main.user_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class User_Registration : BaseActivity(), View.OnClickListener {
    @Inject
    lateinit var registrationAPI: LoginViewModule
    lateinit var desies: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val on: UserRegistrationBinding = DataBindingUtil.setContentView<UserRegistrationBinding>(this, R.layout.user_registration)

        val intent = intent
        val ob = RegistrationData(ObservableField<String>(""))
        ob.age = intent.getStringExtra("age")
        desies = intent.getStringArrayListExtra("desies") as ArrayList<String>
        ob.disease = desies
        ob.gender = intent.getStringExtra("gender")
        ob.weight = intent.getStringExtra("weight")
        ob.height = intent.getStringExtra("height")

        on.model = ob

    }
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.verify_now -> {
                val registradsata = RegistrationData(ObservableField<String>(""))
                registradsata.age = etUserAge.text.toString()
                registradsata.gender = etUserAge.text.toString()
                registradsata.weight = etUserAge.text.toString()
                registradsata.height = etUserAge.text.toString()
                registradsata.disease = desies

                val call: Call<Restration_response> = registrationAPI.returnBackToView(registradsata)
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
    }

}