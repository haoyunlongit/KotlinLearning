package com.example.kotlinlearning

import androidx.multidex.MultiDexApplication
import com.flurry.android.FlurryAgent
import com.google.android.gms.ads.MobileAds

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author stevenhao
 * @date 2022/2/22
 */
class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
        FlurryAgent.Builder()
            .withLogEnabled(true)
            .build(this, "4XCQF9CYRM7V5RQYBPDY")
    }
}