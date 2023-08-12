package com.jess.camp.main

import androidx.fragment.app.Fragment
import com.jess.camp.R
import com.jess.camp.bookmark.BookmarkFragment
import com.jess.camp.todo.TodoFragment

enum class MainTabs(
    val fragment: Fragment,
    val titleRes: Int
) {
    TODO(TodoFragment.newInstance(), R.string.main_tab_todo_title),
    BOOKMARK(BookmarkFragment.newInstance(), R.string.main_tab_bookmark_title)
}