package fieldx.mobile.com.atiyaherb

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

    }

    fun buildLabel(text: String, tag: String): TextView {
        var textView = TextView(this)
        textView.text = text
        textView.tag = tag
        textView.textSize = 13F
        textView.setPadding(Globlefunction.dpToPx(8F, mContext).toInt(), Globlefunction.dpToPx(5F, mContext).toInt(), Globlefunction.dpToPx(8F, mContext).toInt(), Globlefunction.dpToPx(5F, mContext).toInt())
        textView.setBackgroundResource(R.drawable.label_bg)
        textView.setOnClickListener { println(textView.tag) }
        return textView
    }


}
