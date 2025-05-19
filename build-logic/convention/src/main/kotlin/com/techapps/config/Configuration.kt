package com.techapps.config

object Configuration {
    const val compileSdk = 35
    const val minSdk = 28
    const val targetSdk = 35

    object Version {
        const val majorVersion = 1
        const val minorVersion = 0
        const val patchVersion = 0
        const val versionName = "$majorVersion.$minorVersion.$patchVersion"
        const val versionCode = 1
    }

}