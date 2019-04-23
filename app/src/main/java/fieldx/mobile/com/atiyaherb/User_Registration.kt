package fieldx.mobile.com.atiyaherb

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
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
import java.util.*
import javax.inject.Inject


class User_Registration : BaseActivity(), View.OnClickListener {


    @Inject
    lateinit var registrationAPI: LoginViewModule
    lateinit var desies: ArrayList<String>
    lateinit var registrationData: RegistrationData
    override fun setLayout(): Int {
        return R.layout.user_registration
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val on: UserRegistrationBinding = DataBindingUtil.setContentView<UserRegistrationBinding>(this, R.layout.user_registration)

        val intent = intent
        registrationData = RegistrationData(ObservableField<String>(""))
        registrationData.age = intent.getStringExtra("age")
        desies = intent.getStringArrayListExtra("desies") as ArrayList<String>
        registrationData.disease = desies
        registrationData.gender = intent.getStringExtra("gender")
        registrationData.weight = intent.getStringExtra("weight")
        registrationData.height = intent.getStringExtra("height")
        registrationData.name = intent.getStringExtra("user_name")
        registrationData.mobile = intent.getStringExtra("mobile_number")
        on.model = registrationData
        verify_now.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.verify_now -> {
                verify()
            }

        }
    }

    fun verify() {
        if (!checkActiveNetwork()) {
            showToast(getString(R.string.nointernet))
            return
        }
        showProgressBar()
//        val registradsata = RegistrationData(ObservableField<String>(""))
//        registradsata.age = etUserAge.text.toString()
//        registradsata.gender = etUsergender.text.toString()
//        registradsata.weight = etUserWeight.text.toString()
//        registradsata.height = etUserHeight.text.toString()
//        registradsata.name = etUserName.text.toString()
//        registradsata.mobile = etUserMobile.text.toString()
//        registradsata.disease = desies

        val call: Call<Restration_response> = registrationAPI.returnBackToView(registrationData)
        call.enqueue(object : Callback<Restration_response> {
            override fun onFailure(call: Call<Restration_response>?, t: Throwable?) {
                Log.i("ResonFailure FFFFFFFFF ", t?.stackTrace.toString());
                hideProgressBar()
                showToast("Some error occurred")
            }

            override fun onResponse(call: Call<Restration_response>?, response: Response<Restration_response>) {
                if (response.isSuccessful) {
                    Log.i(" FFFFFFFFF KODARE  ", response.body()?.status_msg)//Gson().toJson(response?.body())
                    Log.i(" FFFFFFFFF KODARE  ", response.body()?.status_api)
                    showToast(response.body()?.status_msg.toString())
                    hideProgressBar()
                } else {
                    hideProgressBar()
                    Log.i(" FFFFFFFFF KODARE  ", response.errorBody().toString())
                    showToast(response.errorBody().toString())
                }
            }

        })

    }


}