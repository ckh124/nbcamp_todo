package com.jess.camp.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jess.camp.databinding.FabTapBinding
import com.jess.camp.todo.TodoFragment
import com.jess.camp.todo.TodoModel

class FabActivity:AppCompatActivity() {

    private val bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FabTapBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.undoBtn.setOnClickListener {

            finish()

        }


        binding.regiBtn.setOnClickListener{
            val title = binding.detailtext.text.toString()
            val detailText = binding.title.text.toString()
            if ( title.isEmpty()){
                Toast.makeText(this,"제목을 입력해주세요", Toast.LENGTH_SHORT).show()
            }else if(detailText.isEmpty()){
                Toast.makeText(this,"내용을 입력해주세요", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"할일 등록", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("title",detailText)
                intent.putExtra("detailText",title)
                setResult(RESULT_OK,intent)
                finish()

            }

        }

    }


}