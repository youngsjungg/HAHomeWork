import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.hahomework.apps.configureKotlinAndroid
import com.hahomework.config.BuildTypeConfig
import com.hahomework.config.Configuration
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureKotlinAndroid(this)

                defaultConfig {
                    applicationId = "com.hahomework"
                    targetSdk = Configuration.targetSdk
                    multiDexEnabled = true
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    debug {
                        isMinifyEnabled = false
                        isDebuggable = true
                        buildConfigField("String", BuildTypeConfig.Config.Fields.BASE_URL, "\"${BuildTypeConfig.Config.BASE_URL}\"")
                    }

                }

                buildFeatures {
                    buildConfig = true
                }
            }
            extensions.getByType<KotlinAndroidProjectExtension>().apply {
                configureKotlinAndroid(this)
            }
        }
    }
}