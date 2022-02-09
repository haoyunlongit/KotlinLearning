package com.example.kotlinlearning.lambda

import android.app.Activity
import android.app.Application
import android.view.View
import android.widget.TextView

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author stevenhao
 * @date 2022/2/9
 */
class LambdaLearning(val mContext: Activity) {
    
    fun fun1() {
        val temp: View = TextView(mContext)
        temp.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                println("on click listener")
            }

        })
    }

    fun fun2() {
        val temp: View = TextView(mContext)
        temp.setOnClickListener {
            println("on click listener")
        }
    }

    fun fun3() {
        val temp: View = TextView(mContext)
        temp.setOnClickListener { v: View -> Unit

        }
    }
}