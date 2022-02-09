package com.example.kotlinlearning.lambda

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author stevenhao
 * @date 2022/2/9
 */

fun main() {
    val lambdaLearning2 = LambdaLearning2()

}

class LambdaLearning2 {

    //lambda 做为变量
    fun method1() {
        val method1 = {
            //do some thing
        }
        var number = method1()

        //var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }
        val method2 : (Int) -> Int = {
            it + 3
            100
        }
        method2(100)

        //val/var 变量名 = { 参数1 ： 类型，参数2 : 类型, ... -> 操作参数的代码 }
        val method3 = { t1 : Int, t2: Int ->
            val t3: Int = t1 + t2 + 3
            t3
        }
        method3(10, 100)
    }

}