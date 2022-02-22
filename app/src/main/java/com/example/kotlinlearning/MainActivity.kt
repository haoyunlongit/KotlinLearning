package com.example.kotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kotlinlearning.coroutine.CoroutineLearningActivity
import com.example.kotlinlearning.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(loginBinding.root)
        loginBinding.textView.setOnClickListener {

            GlobalScope.launch(Dispatchers.Main) {
                println("~~~~~" + (Thread.currentThread() == mainLooper.thread))
                coroutineLearning()
            }
        }

        loginBinding.textView3.setOnClickListener {
            myTestFunction()
        }
    }

    private suspend fun coroutineLearning() {
        val tempIntent = Intent(this, CoroutineLearningActivity::class.java)
        startActivity(tempIntent)
        val temp = GlobalScope.async {
            println("~~~~~dosync")
            delay(5000)
            println("~~~~~~~endsync")
            return@async 500
        }
        temp.await()
        println("~~~~~")
    }

    private fun myTestFunction() {
        println("~~~~~~~~~ myTestFunction");
    }
}