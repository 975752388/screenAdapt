package com.zky.lib

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.ComponentCallbacks2
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.Log

class ScreenAdapt {
    companion object{
        private var mDesignWidth=0f
        private var appDensity=0f
        private var appScaleDensity=0f
        fun initDesignWidthDp(application: Application,designWidth:Float){
            if (designWidth <=0){
                return
            }
            mDesignWidth = designWidth
            val displayMetrics =  application.resources.displayMetrics
            if (appDensity==0f){
                appDensity = displayMetrics.density
                appScaleDensity = displayMetrics.scaledDensity


            }
            val targetDensity = displayMetrics.widthPixels/ designWidth
            val targetScaleDensity = targetDensity* appScaleDensity/ appDensity
            val targetDensityDpi = targetDensity*160
            val callBack = ScreenLifecycle(targetDensity,targetScaleDensity,targetDensityDpi)

            application.registerComponentCallbacks(object : ComponentCallbacks{
                override fun onLowMemory() {

                }

                override fun onConfigurationChanged(newConfig: Configuration) {
                    if (newConfig.fontScale>0){
                        appScaleDensity = application.resources.displayMetrics.scaledDensity
                        callBack.targetScaleDensity = targetDensity* appScaleDensity/ appDensity
                    }
                }

            })

            application.registerActivityLifecycleCallbacks(callBack)
        }
        fun initDesignWidthDp(application: Application,designWidth:Float,activity: Activity){
            if (designWidth <=0){
                return
            }
            mDesignWidth = designWidth
            val displayMetrics =  application.resources.displayMetrics
            if (appDensity==0f){
                appDensity = displayMetrics.density
                appScaleDensity = displayMetrics.scaledDensity


            }
            application.registerComponentCallbacks(object : ComponentCallbacks{
                override fun onLowMemory() {

                }

                override fun onConfigurationChanged(newConfig: Configuration) {
                    if (newConfig.fontScale>0){
                        appScaleDensity = application.resources.displayMetrics.scaledDensity

                    }
                }

            })

            val targetDensity = displayMetrics.widthPixels/ designWidth
            val targetScaleDensity = targetDensity* appScaleDensity/ appDensity
            val targetDensityDpi = targetDensity*160

            val matrics = activity.resources.displayMetrics
            matrics.densityDpi = targetDensityDpi.toInt()
            matrics.density = targetDensity
            matrics.scaledDensity= targetScaleDensity

        }
        fun cancleAdapt(activity: Activity){
            val systemMatrics = Resources.getSystem().displayMetrics
            val activityMatrics = activity.resources.displayMetrics
            activityMatrics.density = systemMatrics.density
            activityMatrics.scaledDensity = systemMatrics.scaledDensity
            activityMatrics.densityDpi = systemMatrics.densityDpi
        }
    }
}