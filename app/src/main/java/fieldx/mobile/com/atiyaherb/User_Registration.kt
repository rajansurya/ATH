package fieldx.mobile.com.atiyaherb

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.util.Log
import com.activity.module.LoginViewModule
import com.data.model.RegistrationData
import com.data.model.Restration_response
import fieldx.mobile.com.atiyaherb.databinding.UserRegistrationBinding
import kotlinx.android.synthetic.main.user_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class User_Registration : BaseActivity() {
    @Inject
    lateinit var registrationAPI: LoginViewModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.user_registration)
        var on: UserRegistrationBinding = DataBindingUtil.setContentView<UserRegistrationBinding>(this, R.layout.user_registration)

        var intent = intent
        var age = intent.getStringExtra("age")
        var gender = intent.getStringExtra("gender")
        var weight = intent.getStringExtra("weight")
        var height = intent.getStringExtra("height")
        var desies = intent.getStringArrayListExtra("desies") as ArrayList<String>
        var desiesst: String = ""
        desies?.forEach { desiesst = desiesst + it + "," }

        var ob= RegistrationData(ObservableField<String>(""))
        ob.age=intent.getStringExtra("age")
        ob.disease=desies
        ob.gender=intent.getStringExtra("gender")
        ob.weight=intent.getStringExtra("weight")
        ob.height=intent.getStringExtra("height")
        on.model = ob


        //etUserAge.setText(age)
       // etUserDeaise.setText(desiesst)
        //etUserHeight.setText(height)
       // etUserWeight.setText(weight)
        //etUsergender.setText(gender)

        var registradsata = RegistrationData(ObservableField<String>(""))
        registradsata.age = age
        registradsata.gender = gender
        registradsata.weight = weight
        registradsata.height = height
        registradsata.disease = desies!!
        // registradsata.mobile = etUserMobile.text.toString()

        var call: Call<Restration_response> = registrationAPI.returnBackToView(registradsata)
        println("FFFFFFFFF" + call)


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