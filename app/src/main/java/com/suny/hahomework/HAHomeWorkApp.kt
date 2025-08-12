package com.suny.hahomework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class HAHomeWorkApp: Application() {

    override fun onCreate() {
        super.onCreate()

        timberInit()
    }

    private fun timberInit() {
        Timber.plant(TimberDebugTree())
    }
}