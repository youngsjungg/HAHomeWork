package com.hahomework.config

object BuildTypeConfig {

    object Config {
        const val PROGUARD_ANDROID = "proguard-android.txt"
        const val PROGUARD_RULES = "../buildSrc/proguard-rules.pro"
        const val BASE_URL = "https://dapi.kakao.com/v3"

        object Fields {
            const val BASE_URL = "BASE_URL"
        }
    }
}