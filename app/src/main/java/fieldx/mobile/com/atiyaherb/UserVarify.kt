package fieldx.mobile.com.atiyaherb

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.activity.module.User_verification_Module
import com.view.callback.ViewCallbAck
import kotlinx.android.synthetic.main.user_verify.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class UserVarify : BaseActivity(), View.OnClickListener, ViewCallbAck {

    override fun otpResponse(otp: String) {
        val intent = Intent(applicationContext, User_Health_Info::class.java)
        intent.putExtra("user_name", etUserName.text.toString())
        intent.putExtra("mobile_number", etUserMobile.text.toString())
        startActivity(intent)
        // startActivityView(User_Health_Info::class.java)

    }

    lateinit var store_otp: String

    @Inject
    lateinit var user_verification_Module: User_verification_Module

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.verify_now -> {
                if (!validation())
                    return
                showProgressBar()

                store_otp = getRandomNumberString()
                val msg = "Use Code " + store_otp + " to verify your mobile on HSK."
                val otpur = API_URL_FILE.OTP_API + "&to=" + etUserMobile.text.toString() + "&text=" + msg
                val call = user_verification_Module.sendOTPToMobile(otpur)

                call.enqueue(object : Callback<Any> {
                    override fun onFailure(call: Call<Any>?, t: Throwable?) {
                        //Log.i("OTP XXX ", t?.message)
                        hideProgressBar()

                    }

                    override fun onResponse(call: Call<Any>?, response: Response<Any>) {
                        //  Log.i("OTP has been  ", response.body()?.toString())
                        if (response.isSuccessful) {
                            hideProgressBar()
                            showToast("OTP has been send to Given mobile no.")
                            val dalog: OTPAlertDialogFragment = OTPAlertDialogFragment.newInstanse("Enter OTP", this@UserVarify, this@UserVarify, store_otp)
                            dalog.show(supportFragmentManager, "dialog")
                        }
                    }

                })
            }
        }
    }

    fun validation(): Boolean {
        if (TextUtils.isEmpty(etUserName.text.toString())) {
            showToast("Please enter your Name.")
            return false
        } else if (TextUtils.isEmpty(etUserMobile.text.toString())) {
            showToast("Please enter your Mobile no.")
            return false
        } else if (etUserMobile.text.toString().length != 10) {
            showToast("Entered Mobile no is wrong.")
            return false
        }
        return true
    }

    override fun setLayout(): Int {
        return R.layout.user_verify
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verify_now.setOnClickListener(this)
    }

    fun getRandomNumberString(): String {
        val randam = Random()
        val number = randam.nextInt(999999)
        return String.format("%06d", number)
    }
}


