package com.example.machinetest_android_shijin

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        Log.d("Test","Test")
        // Example: Initialize Timber for logging

    }

}