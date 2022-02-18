package com.example.kotlinlearning.coroutine

import kotlinx.coroutines.*
import okhttp3.internal.wait
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author stevenhao
 * @date 2022/2/10
 */

suspend fun main() {

    val temp = GlobalScope.async {
        log("1")
        delay(2000)
        log("2")
        return@async 100
    }
    val time = System.currentTimeMillis()
    println("~~~~" + temp.await())
    println("~~~~cost time " + (System.currentTimeMillis() - time))


//    GlobalScope.async {
//
//    }
//    GlobalScope.launch(MyContinuationInterceptor()) {
//        log("1")
//        val job = async {
//            log("2")
//            delay(1000)
//            log("3")
//            "Hello"
//        }
//        log("4")
//        val result = job.await()
//        log("5. $result")
//    }.join()
//    log("6")
}

class MyContinuationInterceptor: ContinuationInterceptor {
    override val key = ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>) = MyContinuation(continuation)
}

class MyContinuation<T>(val continuation: Continuation<T>): Continuation<T> {
    override val context = continuation.context
    override fun resumeWith(result: Result<T>) {
        log("<MyContinuation> $result" )
        continuation.resumeWith(result)
    }
}

private fun log(num: String) {
    println("~~~$num" + Thread.currentThread().name)
}