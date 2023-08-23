package com.jess.camp.main

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayoutMediator
import com.jess.camp.R
import com.jess.camp.databinding.MainActivityBinding
import com.jess.camp.todo.TodoFragment
import com.jess.camp.todo.TodoListAdapter
import com.jess.camp.todo.TodoModel

class MainActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: MainActivityBinding
    private lateinit var title:String
    private lateinit var detailText:String





    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setResultNext()
        initView()

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){//viewPager의 변화가 생기는지 감지
            override fun onPageSelected(position: Int) {//viewpage의 변화가 일어나면
            super.onPageSelected(position)
            binding.fabAddTodo.hide()//fabAddTodo를 숨김
            onPageChangCallback(position, binding.fabAddTodo)//callback 함수를 통해 fabAddTodo 다시 출력
            }
        }
        )

    }


    private fun initView() = with(binding) {
        toolBar.title = getString(R.string.app_name)

        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab, position ->
            tab.text = viewPagerAdapter.getTitle(position)//탭의 텍스트(타이틀) 설정
        }.attach()
        // fab
        fabIntent()

    }

    fun fabIntent(){
        binding.fabAddTodo.setOnClickListener {//fabaddTodo 클릭시 실행

            val fabIntent = Intent(this, FabActivity::class.java)
            resultLauncher.launch(fabIntent)//FabActivity로 이동


        }
    }
    private fun onPageChangCallback(position:Int,btn: FloatingActionButton){//콜백 기능 구현
        if(position == 0){
            btn.show()

        }
    }
    fun setResultNext(){

        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->

            if(result.resultCode == RESULT_OK){

                title = result.data?.getStringExtra("title") ?: ""
                detailText = result.data?.getStringExtra("detailText") ?: ""
                viewPagerAdapter.getTodoFragment().addContentTodoModel(TodoModel(title,detailText))





            }

        }

    }




}