package fieldx.mobile.com.atiyaherb

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.TextView
import dagger.android.AndroidInjection
import javax.inject.Inject
import android.graphics.drawable.StateListDrawable


abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

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

}
