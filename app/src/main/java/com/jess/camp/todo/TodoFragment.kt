package com.jess.camp.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jess.camp.databinding.TodoFragmentBinding

class TodoFragment : Fragment() {

    companion object {
        fun newInstance() = TodoFragment()

    }

    var testList = arrayListOf<TodoModel>()

    private var _binding: TodoFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        TodoListAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TodoFragmentBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

        // for test

    }

    private fun initView() = with(binding) {
        todoList.adapter = listAdapter
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    fun addcontent(title:String,detailText:String){
        testList.add(TodoModel(title,detailText))
        listAdapter.addItems(testList)
        testList.clear()


    }
    fun addContentTodoModel(item:TodoModel){
        listAdapter.addItem(item)
    }

}