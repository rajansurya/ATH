package fieldx.mobile.com.atiyaherb

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() ,View.OnClickListener{
    override fun onClick(p0: View) {
        when(p0.id){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        craeteView()
    }

    fun craeteView() {
        var list=ArrayList<String>()
        list.add("I am a?")
        list.add("Age")
        list.add("Height")

        list.forEachIndexed { index, s ->  flowdistrict.addView(buildLabel(s, index.toString())) }

    }


}
