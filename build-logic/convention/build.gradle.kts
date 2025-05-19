plugins {
    `kotlin-dsl`
}

group = "com.baseinapps.buildlogic"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    compileOnly(libs.android.gradlePlugin)	// android gradle plugin
    compileOnly(libs.kotlin.gradlePlugin)  // kotlin gradle plugin
    compileOnly(libs.compose.compiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "baseinapps.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "baseinapps.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "baseinapps.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "baseinapps.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryFlavors") {
            id = "baseinapps.android.library.flavors"
            implementationClass = "AndroidLibraryFlavorsConventionPlugin"
        }
        register("androidFeature") {
            id = "baseinapps.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "baseinapps.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}