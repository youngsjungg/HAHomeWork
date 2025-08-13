plugins {
    id("hahomework.android.library")
    id("hahomework.android.hilt")
    alias(libs.plugins.kotlin.android)}

android {
    namespace = "core.common"

    buildFeatures {
        buildConfig = true
    }

}

dependencies {
    implementation(projects.core.network)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //etc
    implementation(libs.timber)
}