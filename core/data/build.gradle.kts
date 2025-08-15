plugins {
    id("hahomework.android.library")
    id("hahomework.android.hilt")
}

android {
    namespace = "core.data"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.model)

    implementation(projects.core.network)
    implementation(projects.core.domain)
    implementation(projects.core.datastore)

    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.common)

    //etc
    implementation(libs.timber)
}