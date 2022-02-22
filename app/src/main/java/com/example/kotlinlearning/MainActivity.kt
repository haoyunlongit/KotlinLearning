package com.example.kotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.collection.ArrayMap
import com.example.kotlinlearning.coroutine.CoroutineLearningActivity
import com.example.kotlinlearning.databinding.ActivityMainBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityMainBinding
    private lateinit var remoteConfig: FirebaseRemoteConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(ArrayMap<String, Any>().apply {
            put("hahah", "123123")
        })

        remoteConfig.fetchAndActivate()

        loginBinding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(loginBinding.root)
        loginBinding.textView.setOnClickListener {

            GlobalScope.launch(Dispatchers.Main) {
                val tempStr = remoteConfig.getString("hahah")
                println("~~~~~##" + tempStr)
//                coroutineLearning()
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