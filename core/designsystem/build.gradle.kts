plugins {
    id("hahomework.android.library")
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "core.designsystem"

    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)

    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.landscapist.bom)
    implementation(libs.landscapist.glide)
    implementation(libs.landscapist.coil)
    implementation(libs.landscapist.placeholder)
    implementation(libs.landscapist.animation)
    implementation(libs.landscapist.transformation)

    //etc
    implementation(libs.timber)
}