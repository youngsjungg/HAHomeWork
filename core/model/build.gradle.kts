plugins {
    id("hahomework.android.library")
    id("hahomework.android.hilt")
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "core.model"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.sandwich)
    implementation(libs.sandwich.retrofit)
    implementation(libs.kotlinx.serialization.json)

    //etc
    implementation(libs.timber)
}