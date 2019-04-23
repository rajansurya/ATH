package fieldx.mobile.com.atiyaherb

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
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(Runnable {
            Splash@ this.finish()
            if (sharedPreferences.getString("stepCompleted", "0").equals("0")) {
                startActivityView(InfoPage::class.java)
            } else if (sharedPreferences.getString("stepCompleted", "0").equals("1")) {
                startActivityView(UserVarify::class.java)
            }
            /*else if (sharedPreferences.getString("stepCompleted", "").equals("2")) {
                startActivityView(User_Health_Info::class.java)
            } */
            else if (sharedPreferences.getString("stepCompleted", "0").equals("3")) {
                startActivityView(HomeActivity_View::class.java)
            }
        }, 2000)
    }

}