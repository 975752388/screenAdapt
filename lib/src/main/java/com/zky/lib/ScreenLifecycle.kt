package com.zky.lib

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log

class ScreenLifecycle(val targetDensity:Float,var targetScaleDensity:Float,val targetDensityDpi:Float):Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.e("==","${activity.javaClass.simpleName} onActivityCreated")
        Log.e("==","scale= $targetScaleDensity")
        val displayMetrics =  activity.resources.displayMetrics
        displayMetrics.density = targetDensity
        displayMetrics.scaledDensity = targetScaleDensity
        displayMetrics.densityDpi = targetDensityDpi.toInt()
    }

    override fun onActivityResumed(activity: Activity) {

    }
}