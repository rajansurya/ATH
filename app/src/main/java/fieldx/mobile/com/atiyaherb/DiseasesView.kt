package fieldx.mobile.com.atiyaherb

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.diseaseview.*

/**
 * Created by Rajan on 03-03-2019.
 */
class DiseasesView:BaseActivity() ,View.OnClickListener{
    override fun setLayout(): Int {
        return R.layout.diseaseview
    }

    var storepositio:HashMap<String,String> = HashMap()
    lateinit var progressBar: ProgressBar

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.submit->{
                val intents = Intent(applicationContext, User_Registration::class.java)
                val intent=intent
                intents.putExtra("gender", intent.getStringExtra("gender"))
                intents.putExtra("age", intent.getStringExtra("age"))
                intents.putExtra("weight", intent.getStringExtra("weight"))
                intents.putExtra("height", intent.getStringExtra("height"))
                val st:ArrayList<String> = ArrayList()
                for ( sta:String in storepositio.keys){
                    st.add(storepositio.get(sta)!!)
                }
                intents.putExtra("desies", st)

                //println("storepositio.values "+st)
                startActivity(intents)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intent=intent
        var age=intent.getStringExtra("age")
        var gender=intent.getStringExtra("gender")
        var weight=intent.getStringExtra("weight")
        var height=intent.getStringExtra("height")
        println("weight  "+weight)
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
        submit.setOnClickListener(this)
        progressBar= ProgressBar(this,null,android.R.attr.progressBarStyleSmall)


    }

    @SuppressLint("ResourceType")
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
            if (storepositio.containsKey(textView.tag.toString())){
                textView.isSelected = false
                storepositio.remove(textView.tag.toString())
            }else{
                storepositio.put(textView.tag.toString(),textView.text.toString())
            }

        }

        return textView
    }


}