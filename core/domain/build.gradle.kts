plugins {
    id("hahomework.android.library")
    id("hahomework.android.hilt")
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "core.domain"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.model)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.common)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}