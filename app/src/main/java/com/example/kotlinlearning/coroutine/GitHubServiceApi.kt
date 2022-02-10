package com.example.kotlinlearning.coroutine

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author stevenhao
 * @date 2022/2/10
 */
interface GitHubServiceApi {
    @GET("users/{login}")
    fun getUser(@Path("login") login: String): Call<User>
}

data class User(val id: String, val name: String, val url: String)