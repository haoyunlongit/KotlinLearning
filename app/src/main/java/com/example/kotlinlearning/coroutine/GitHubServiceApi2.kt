package com.example.kotlinlearning.coroutine

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:Rotrofit 协程改造
 *
 * @author stevenhao
 * @date 2022/2/10
 */
interface GitHubServiceApi2 {
    @GET("users/{login}")
    fun getUser(@Path("login") login: String): Deferred<User>
}