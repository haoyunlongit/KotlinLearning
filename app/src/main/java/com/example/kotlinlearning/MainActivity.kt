package com.example.kotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.collection.ArrayMap
import com.example.kotlinlearning.coroutine.CoroutineLearningActivity
import com.example.kotlinlearning.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityMainBinding
    private lateinit var remoteConfig: FirebaseRemoteConfig
    private val firebaseAnalytics by lazy { FirebaseAnalytics.getInstance(baseContext) }

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

            GlobalScope.launch(Dispatchers.IO) {
                val tempStr = AdvertisingIdClient.getAdvertisingIdInfo(baseContext)
                println("~~~~~##" + tempStr.id)
            }
        }

        loginBinding.textView3.setOnClickListener {
            myTestFunction()
        }

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.METHOD, "SIGN_UP")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle)

        MobileAds.initialize(this) {}

        val adView = loginBinding.adView
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

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