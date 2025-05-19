plugins {
    id("baseinapps.android.library")
    id("baseinapps.android.hilt")
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