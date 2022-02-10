package com.example.kotlinlearning.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlearning.databinding.CoroutineLearningActivityBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author stevenhao
 * @date 2022/2/9
 */
class CoroutineLearningActivity : AppCompatActivity() {

    private lateinit var dataBinding: CoroutineLearningActivityBinding

    private lateinit var gitHubServiceApi: GitHubServiceApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = CoroutineLearningActivityBinding.inflate(layoutInflater, null, false)
        setContentView(dataBinding.root)

        dataBinding.textView2.setOnClickListener {
            doRequest()
        }

        val retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        gitHubServiceApi = retrofit.create(GitHubServiceApi::class.java)
    }

    private fun doRequest() {
        gitHubServiceApi.getUser("haoyunlongit").enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
//                handler.post { showError(t) }
                println("~~~~~~~")
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val user: User? = response.body()
                println("~~~~~~~")
//                handler.post { response.body()?.let(::showUser) ?: showError(NullPointerException()) }
            }
        })
    }
}