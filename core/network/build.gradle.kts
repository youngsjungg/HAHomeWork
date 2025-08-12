plugins {
    id("hahomework.android.library")
    id("hahomework.android.hilt")
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "core.network"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(projects.core.data)
    implementation(projects.core.datastore)
    implementation(projects.core.model)


    // network
    implementation(libs.sandwich)
    implementation(libs.sandwich.retrofit)
    implementation(platform(libs.retrofit.bom))
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.retrofitBundle)
    implementation(libs.retrofit.converter)
    implementation(libs.apollo)
    implementation(libs.apollo.coroutine)

    // json parsing
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.gson)

    //etc
    implementation(libs.timber)
}