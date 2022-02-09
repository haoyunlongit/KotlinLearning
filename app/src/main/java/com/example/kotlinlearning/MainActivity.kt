package com.example.kotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kotlinlearning.coroutine.CoroutineLearningActivity
import com.example.kotlinlearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(loginBinding.root)
        loginBinding.textView.setOnClickListener {
            coroutineLearning()
        }
    }

    private fun coroutineLearning() {
        val tempIntent = Intent(this, CoroutineLearningActivity::class.java)
        startActivity(tempIntent)
    }
}