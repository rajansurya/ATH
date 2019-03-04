package fieldx.mobile.com.atiyaherb

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import com.view.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.infopage_view.*

class InfoPage : FragmentActivity() {
    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.infopage_view)
        var listfrg = ArrayList<Fragment>()
        listfrg.add(InfoPage1.newInstance(0))
        listfrg.add(InfoPage1.newInstance(1))
        listfrg.add(InfoPage1.newInstance(2))
        listfrg.add(InfoPage1.newInstance(3))
        var adapter = ViewPagerAdapter(supportFragmentManager, listfrg)


        viewpager.adapter = adapter
    }

    fun moveToNext() {

        if (count < 4) {
            viewpager.setCurrentItem(count)
            count=count+1
        }
    }
    fun onClickfun(view:View){
        moveToNext()
    }

}