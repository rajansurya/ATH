package fieldx.mobile.com.atiyaherb

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var mContext: Context
    lateinit var progressbar: AlertDialog

    abstract fun setLayout(): Int
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
    }


    /* fun stateListDrawble(): StateListDrawable {
         val states = StateListDrawable()
         states.addState(intArrayOf(android.R.attr.state_pressed),
                 resources.getDrawable(R.drawable.gender_icon_black))
         states.addState(intArrayOf(android.R.attr.state_focused),
                 resources.getDrawable(R.drawable.gender_icon_black))
         states.addState(intArrayOf(),
                 resources.getDrawable(R.drawable.calender_icon_black))
         return states
     }*/
    fun showProgressBar() {
        progressbar = Globlefunction.getProgressDialog(this)
        progressbar.show()
    }

    fun hideProgressBar() {
        progressbar.dismiss()
    }
}
