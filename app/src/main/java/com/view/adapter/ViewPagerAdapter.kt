package com.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter constructor(fragmentmanger: FragmentManager,var allfragment: ArrayList<Fragment>) : FragmentPagerAdapter(fragmentmanger) {
    //lateinit var allfragment: ArrayList<Fragment>
    fun addFragment(fragment: Fragment) {
        allfragment.add(fragment)
    }

    override fun getItem(p0: Int): Fragment {
        return allfragment.get(p0)
    }

    override fun getCount(): Int {
        return allfragment.size
    }

}