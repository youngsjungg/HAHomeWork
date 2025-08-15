plugins {
    id("hahomework.android.feature")
    id("hahomework.android.hilt")
}

android {
    namespace = "com.feature.home"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)

    implementation(libs.androidx.hilt.navigation.compose)

    //etc
    implementation(libs.timber)
}