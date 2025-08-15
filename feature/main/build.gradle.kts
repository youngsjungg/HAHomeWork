plugins {
    id("hahomework.android.feature")
    id("hahomework.android.hilt")
}

android {
    namespace = "com.feature.main"
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.like)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewModel.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(project(":core:navigation"))

    //etc
    implementation(libs.timber)
}