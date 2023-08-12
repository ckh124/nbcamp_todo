package com.jess.camp.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    fun getTitle(position: Int): Int {
        return MainTabs.values()[position].titleRes
    }

    override fun getItemCount(): Int {
        return MainTabs.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return MainTabs.values()[position].fragment
    }
}