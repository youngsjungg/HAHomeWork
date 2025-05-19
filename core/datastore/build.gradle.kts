plugins {
    id("baseinapps.android.library")
    id("baseinapps.android.hilt")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "core.datastore"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.model)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.androidx.dataStore)
    implementation(libs.androidx.pref.dataStore.core)
    implementation(libs.androidx.proto.dataStore.core)
    implementation(libs.google.protobuf)

    implementation(libs.hilt.android)
    implementation(libs.timber)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }

    generateProtoTasks {
        all().onEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}