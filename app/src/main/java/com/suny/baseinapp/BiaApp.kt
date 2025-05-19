package com.example.techapps

import android.app.Application
import com.suny.baseinapp.TimberDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BiaApp: Application() {

    override fun onCreate() {
        super.onCreate()

        timberInit()
    }

    private fun timberInit() {
        Timber.plant(TimberDebugTree())
    }
}