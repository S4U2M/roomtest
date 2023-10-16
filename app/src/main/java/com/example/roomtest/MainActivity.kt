package com.example.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomtest.databinding.MainActivityBinding
import com.example.roomtest.db.TextDatabase
import com.example.roomtest.entity.TextEntity
import com.example.roomtest.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    lateinit var textEntity: TextEntity
    lateinit var wordEntity: WordEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() = with(binding) {
        val db = TextDatabase.getDatabase(this@MainActivity)

        insert.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(TextEntity(0, textInputArea.text.toString()))
                db.wordDao().insert(WordEntity(0,textInputArea.text.toString()))
            }
        }

        getData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().getAllData()
                db.wordDao().getAllData()
                Log.d("데이터", db.textDao().getAllData().toString())
                Log.d("데이터", db.wordDao().getAllData().toString())
            }
        }

        delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
                db.wordDao().deleteAllData()
            }
        }


    }
}