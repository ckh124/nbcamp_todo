package com.jess.camp.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jess.camp.R
import com.jess.camp.bookmark.BookmarkFragment
import com.jess.camp.todo.TodoFragment

class MainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = ArrayList<MainTabs>()

    init {
        fragments.add(
            MainTabs(TodoFragment.newInstance(), "todo")
        )
        fragments.add(
            MainTabs(BookmarkFragment.newInstance(), "Bookmark"),
        )
    }

    fun getTitle(position: Int): String {
        return fragments[position].title
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }
    fun getTodoFragment(): TodoFragment{
        return fragments.get(0).fragment as TodoFragment
    }
}