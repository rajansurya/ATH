package fieldx.mobile.com.atiyaherb

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.view.View
import com.view.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.infopage_view.*

class InfoPage : FragmentActivity() ,ViewPager.OnPageChangeListener{
    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

    }

    override fun onPageSelected(p0: Int) {
        println(p0)
        count=p0
    }

    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.infopage_view)

        var listfrg = ArrayList<Fragment>()
        listfrg.add(InfoPageFragment.newInstance(0))
        listfrg.add(InfoPageFragment.newInstance(1))
        listfrg.add(InfoPageFragment.newInstance(2))
        listfrg.add(InfoPageFragment.newInstance(3))
        listfrg.add(InfoPageFragment.newInstance(4))
        var adapter = ViewPagerAdapter(supportFragmentManager, listfrg)


        viewpager.adapter = adapter
        viewpager.setOnPageChangeListener(this)
    }

    fun moveToNext(view: View) {
        count = count + 1
        if (count < 5) {
            viewpager.setCurrentItem(count)

        }else{
            finishActivity(view)
        }
    }

    fun finishActivity(view: View) {
        InfoPage@this.finish()
        startActivity(Intent(applicationContext,MainActivity::class.java))
    }
}