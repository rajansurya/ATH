package fieldx.mobile.com.atiyaherb

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

/**
 * Created by Rajan on 04-03-2019.
 */
class Splash : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        Handler().postDelayed(Runnable {
            Splash@ this.finish()
            startActivity(Intent(applicationContext, InfoPage::class.java))
        }, 2000)
    }

}