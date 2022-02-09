package com.example.kotlinlearning.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlearning.databinding.CoroutineLearningActivityBinding

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author stevenhao
 * @date 2022/2/9
 */
class CoroutineLearningActivity : AppCompatActivity() {

    private lateinit var dataBinding: CoroutineLearningActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = CoroutineLearningActivityBinding.inflate(layoutInflater, null, false)
        setContentView(dataBinding.root)
    }
}