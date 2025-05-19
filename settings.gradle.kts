import org.gradle.api.Project

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()

    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral() {
            mavenContent {
                releasesOnly()
            }
        }
    }
}

rootProject.name = "baseinapp"
include(":app")

// core
include(
    ":core:domain",
    ":core:analytics",
    ":core:network",
    ":core:model",
    ":core:common",
    ":core:designsystem",
    ":core:data",
    ":core:datastore"
)

//feature
include(
    ":feature:main"
)



