package com.jess.camp.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jess.camp.databinding.BookmarkItemBinding

class BookmarkListAdapter : ListAdapter<BookmarkModel, BookmarkListAdapter.ViewHolder>(diffUtil) {

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<BookmarkModel>() {

            override fun areContentsTheSame(oldItem: BookmarkModel, newItem: BookmarkModel): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: BookmarkModel, newItem: BookmarkModel): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BookmarkItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: BookmarkItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BookmarkModel) = with(binding) {
            title.text = item.title
        }
    }

}