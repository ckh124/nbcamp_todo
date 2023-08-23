package com.jess.camp.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jess.camp.bookmark.BookmarkListAdapter
import com.jess.camp.databinding.TodoItemBinding

class TodoListAdapter : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    var list = ArrayList<TodoModel>()


    fun addItems(items: List<TodoModel>) {//리스트 모두 추가
        list.addAll(items)
        notifyDataSetChanged()
    }
    fun addItem(item:TodoModel){//TodoModel만 추가
        list.add(item)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TodoItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //뷰에 씌워질 내용
        val item = list[position]
        holder.bind(item)
    }


    class ViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TodoModel) = with(binding) {
            title.text = item.title
            detailText.text = item.detail
        }
    }

}