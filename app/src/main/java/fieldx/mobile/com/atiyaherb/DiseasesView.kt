package fieldx.mobile.com.atiyaherb

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.diseaseview.*

/**
 * Created by Rajan on 03-03-2019.
 */
class DiseasesView:BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diseaseview)
        var dieas=ArrayList<String>()
        dieas.add("Ashtama")
        dieas.add("Hypertension")
        dieas.add("Infertility")
        dieas.add("Depression")
        dieas.add("Pimple/Acne")
        dieas.add("Joint pain")
        dieas.add("Weight gain")
        dieas.add("Obesity")
        dieas.add("Diabetes")
        dieas.add("Glucoma")
        dieas.add("Memory loss")
        dieas.add("Hearing condition")
        dieas.add("Hairfall/Baldness")
        flowdiease.childSpacing = 10
        flowdiease.rowSpacing=7F
        dieas.forEachIndexed { index, s -> flowdiease.addView(buildLabel(s,index.toString())) }




    }

    fun buildLabel(text: String, tag: String): TextView {
        var textView = TextView(this)
        textView.text = text
        textView.tag = tag
        textView.textSize = 16F
        textView.isClickable = true
        textView.setTextColor(getResources().getColorStateList(R.drawable.text_color_selector))
        textView.gravity = Gravity.CENTER
//        textView.setCompoundDrawablesWithIntrinsicBounds(drawble, 0, 0, 0)
//        textView.compoundDrawablePadding = 10
        // textView.setTextColor(resources.getColor(R.color.black, null))
       // textView.width = Globlefunction.dpToPx(120F, mContext).toInt()
        textView.typeface = Typeface.create("raleway_light", Typeface.NORMAL)
        // textView.setPadding(Globlefunction.dpToPx(8F, mContext).toInt(), Globlefunction.dpToPx(5F, mContext).toInt(), Globlefunction.dpToPx(8F, mContext).toInt(), Globlefunction.dpToPx(5F, mContext).toInt())
        textView.setBackgroundResource(R.drawable.background_selector)
        textView.setOnClickListener {
            textView.isSelected = true
            println(textView.tag.toString())
        }

        return textView
    }
}