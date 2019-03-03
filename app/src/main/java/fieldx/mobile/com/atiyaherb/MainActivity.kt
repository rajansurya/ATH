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
import kotlinx.android.synthetic.main.age_view.*
import javax.inject.Inject

class MainActivity : BaseActivity(), View.OnClickListener {
    var textviewClicked: TextView? = null
    @Inject
    lateinit var loginViewModule: LoginViewModule
    var agelist = ArrayList<String>(60)
    var heightlist = ArrayList<String>(10)
    var weightlist = ArrayList<String>(150)
    lateinit var recycleadapter :RecyclerViewHorizontalListAdapter

            override fun onClick(p0: View) {
        when (p0.id) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 18..60) {
            agelist.add( i.toString())
        }
        for (i in 1..10) {
            for (j in 1..12) {
                heightlist.add( i.toString() + "'" + j.toString() + "''")
            }
        }
        heightlist.reverse()
        for (i in 1..150)
            weightlist.add( i.toString())
        weightlist.reverse()

        craeteView()
    }

    fun craeteView() {


         recycleadapter = RecyclerViewHorizontalListAdapter(this)
        agelist.reverse()
        recycleadapter.update(agelist)
        idRecyclerViewHorizontalList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        idRecyclerViewHorizontalList.adapter = recycleadapter
        var list = ArrayList<InfoData>()
        list.add(InfoData("I am a ?", R.drawable.age_drawable_left))
        list.add(InfoData("Age", R.drawable.calender_drawable_left))
        list.add(InfoData("Height", R.drawable.height_drawable_left))
        list.add(InfoData("Weight", R.drawable.weight_drawable_left))
        flowdistrict.childSpacing = 10
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
        textView.width = Globlefunction.dpToPx(120F, mContext).toInt()
        textView.typeface = Typeface.create("raleway_light", Typeface.NORMAL)
        // textView.setPadding(Globlefunction.dpToPx(8F, mContext).toInt(), Globlefunction.dpToPx(5F, mContext).toInt(), Globlefunction.dpToPx(8F, mContext).toInt(), Globlefunction.dpToPx(5F, mContext).toInt())
        textView.setBackgroundResource(R.drawable.background_selector)
        textView.setOnClickListener {

            textviewClicked?.let {
                textviewClicked?.isSelected = false
            }
            textView.isSelected = true
            textviewClicked = textView
            println(textView.tag.toString())
            finduserinfo(textView.tag.toString())
        }

        return textView
    }

    fun finduserinfo(tag: String) {
        when (tag) {
            "0" -> {
                age_include.visibility = View.GONE
                gender_include.visibility = View.VISIBLE

                recycleadapter.update(agelist)
            }
            "1" -> {
                age_include.visibility = View.VISIBLE
                gender_include.visibility = View.GONE
                textvalue.text=resources.getString(R.string.age_val)
                recycleadapter.update(agelist)
            }
            "2" -> {
                age_include.visibility = View.VISIBLE
                gender_include.visibility = View.GONE
                textvalue.text=resources.getString(R.string.height_val)
                recycleadapter.update(heightlist)
            }
            "3" -> {
                age_include.visibility = View.VISIBLE
                gender_include.visibility = View.GONE
                textvalue.text=resources.getString(R.string.wieght_val)
                recycleadapter.update(weightlist)
            }

        }
    }

}
