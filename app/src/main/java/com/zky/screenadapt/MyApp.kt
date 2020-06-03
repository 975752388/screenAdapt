package com.zky.screenadapt

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.zky.lib.ScreenAdapt

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
//        ScreenAdapt.initDesignWidthDp(this,360f)

    }
}