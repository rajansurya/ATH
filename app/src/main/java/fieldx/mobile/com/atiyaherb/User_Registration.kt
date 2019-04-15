package fieldx.mobile.com.atiyaherb

import android.app.AlertDialog
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.activity.module.LoginViewModule
import com.data.model.RegistrationData
import com.data.model.Restration_response
import com.google.gson.Gson
import com.view.callback.ViewCallbAck
import fieldx.mobile.com.atiyaherb.databinding.UserRegistrationBinding
import kotlinx.android.synthetic.main.user_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import android.app.ProgressDialog



class User_Registration : BaseActivity(), View.OnClickListener, ViewCallbAck {
    lateinit var store_otp: String
    lateinit  var progressbar: AlertDialog
    override fun otpResponse(otp: String) {
        println("store_otp "+store_otp +"  otp "+otp)
        if (store_otp.equals(otp)) {
            verify()
        } else {
            showToast("OTP did not match")
        }

    }

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
        verify_now.setOnClickListener(this)
        showProgressBar()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.verify_now -> {
                showProgressBar()

                store_otp = getRandomNumberString()
                val msg = "Use Code " + store_otp + " to verify your mobile on HSK."
                val otpur = API_URL_FILE.OTP_API + "&to=" + etUserMobile.text.toString() + "&text=" + msg
                //   val otpurl: String = "http://www.myvaluefirst.com/smpp/sendsms?username=" + "unayurhtpotp" + "&password=" + "unayr981" + "&to=9958778861&from=AHHRBS &text=" + msg + "&dlr-mask=19&dlr-url"
                val call = registrationAPI.sendOTPToMobile(otpur)

                call.enqueue(object : Callback<Any> {
                    override fun onFailure(call: Call<Any>?, t: Throwable?) {
                        Log.i("OTP XXX ", t?.message)
                        hideProgressBar()

                    }

                    override fun onResponse(call: Call<Any>?, response: Response<Any>) {
                        Log.i("OTP has been  ", response.body()?.toString())
                        if (response.isSuccessful) {
                            hideProgressBar()
                            showToast("OTP has been send to Given mobile no.")
                            val dalog: OTPAlertDialogFragment = OTPAlertDialogFragment.newInstanse("Enter OTP", this@User_Registration, this@User_Registration)
                            dalog.show(supportFragmentManager, "dialog")
                        }
                    }

                })

            }

        }
    }

    fun verify() {
        showProgressBar()
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

    fun getRandomNumberString(): String {
        val randam = Random()
        val number = randam.nextInt(999999)
        return String.format("%06d", number)
    }
    fun showProgressBar(){
        progressbar = Globlefunction.getProgressDialog(this)
        progressbar.show()
    }
    fun hideProgressBar(){
        progressbar.dismiss()
    }
}