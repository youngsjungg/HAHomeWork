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

    implementation(projects.core.domain)
    implementation(projects.core.datastore)

    //etc
    implementation(libs.timber)
}