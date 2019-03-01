package fieldx.mobile.com.atiyaherb

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.TextView
import com.activity.module.LoginViewModule
import com.data.model.InfoData
import com.view.adapter.RecyclerViewHorizontalListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), View.OnClickListener {
    var textviewClicked: TextView? = null
    @Inject
    lateinit var loginViewModule: LoginViewModule

    override fun onClick(p0: View) {
        when (p0.id) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        craeteView()
    }

    fun craeteView() {
        var asd=intArrayOf(20,30,40,20,30,40,20,30,40,20,30,40)
        var recycleadapter=RecyclerViewHorizontalListAdapter(this , asd)
        idRecyclerViewHorizontalList.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        idRecyclerViewHorizontalList.adapter=recycleadapter
        var list = ArrayList<InfoData>()
        list.add(InfoData("I am a ?", R.drawable.age_drawable_left))
        list.add(InfoData("Age", R.drawable.calender_drawable_left))
        list.add(InfoData("Height", R.drawable.height_drawable_left))
        list.forEachIndexed { index, s -> flowdistrict.addView(buildLabel(s.name, index.toString(), s.drwable)) }

    }

    fun buildLabel(text: String, tag: String, drawble: Int): TextView {
        var textView = TextView(this)
        textView.text = text
        textView.tag = tag
        textView.textSize = 16F
        textView.isClickable = true
        textView.setTextColor(getResources().getColorStateList(R.drawable.text_color_selector))
        textView.gravity = Gravity.CENTER
        textView.setCompoundDrawablesWithIntrinsicBounds(drawble, 0, 0, 0)
        textView.compoundDrawablePadding = 10
       // textView.setTextColor(resources.getColor(R.color.black, null))
        //textView.width=Globlefunction.dpToPx(100F, mContext).toInt()
        textView.typeface = Typeface.create("raleway_light", Typeface.NORMAL)
        // textView.setPadding(Globlefunction.dpToPx(8F, mContext).toInt(), Globlefunction.dpToPx(5F, mContext).toInt(), Globlefunction.dpToPx(8F, mContext).toInt(), Globlefunction.dpToPx(5F, mContext).toInt())
        textView.setBackgroundResource(R.drawable.background_selector)
        textView.setOnClickListener {

            textviewClicked?.let {
                textviewClicked?.isSelected = false
            }
            //println(textView.tag)
            textView.isSelected = true

            textviewClicked = textView

        }
        return textView
    }


}
