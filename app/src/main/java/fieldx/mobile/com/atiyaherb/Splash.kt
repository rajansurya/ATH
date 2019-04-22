package fieldx.mobile.com.atiyaherb

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import javax.inject.Inject

/**
 * Created by Rajan on 04-03-2019.
 */
class Splash : BaseActivity() {
    override fun setLayout(): Int {
        return R.layout.splash
    }

    @Inject
    lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(Runnable {
            Splash@ this.finish()
            if (sharedPreferences.getBoolean("isfirstTime",true)) {
                startActivity(Intent(applicationContext, InfoPage::class.java))
            }else{
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        }, 2000)
    }

}