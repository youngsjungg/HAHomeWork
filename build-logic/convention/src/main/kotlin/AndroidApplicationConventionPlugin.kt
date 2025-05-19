import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.techapps.apps.configureKotlinAndroid
import com.techapps.config.BuildTypeConfig
import com.techapps.config.BuildTypeConfig.getBuildConfigFields
import com.techapps.config.Configuration
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
                    applicationId = "com.baseinapp"
                    targetSdk = Configuration.targetSdk
                    multiDexEnabled = true
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                signingConfigs {
                    //keyStore 생성후 적용
//                    create("debug") {
//                        storeFile =
//                            file("${rootProject.rootDir}/${BuildTypeConfig.Config.SigningConfig.Debug.STORE_FILE}")
//                        keyAlias = BuildTypeConfig.Config.SigningConfig.Debug.KEY_ALIAS
//                        storePassword = BuildTypeConfig.Config.SigningConfig.Debug.STORE_PASSWORD
//                        keyPassword = BuildTypeConfig.Config.SigningConfig.Debug.KEY_PASSWORD
//                    }

                    create("release") {
                        storeFile =
                            file("${rootProject.rootDir}/${BuildTypeConfig.Config.SigningConfig.Release.STORE_FILE}")
                        keyAlias = BuildTypeConfig.Config.SigningConfig.Release.KEY_ALIAS
                        storePassword = BuildTypeConfig.Config.SigningConfig.Release.STORE_PASSWORD
                        keyPassword = BuildTypeConfig.Config.SigningConfig.Release.KEY_PASSWORD
                    }
                }

                buildTypes {
                    debug {
                        isMinifyEnabled = false
                        isDebuggable = true
                        resValue("string", "temp_key", BuildTypeConfig.Config.ResValue.TEMP_KEY)
                    }

                    release {
                        isMinifyEnabled = true
                        resValue("string", "temp_key", BuildTypeConfig.Config.ResValue.TEMP_KEY) //실 적용시에는 debug와 분리된 키값 사용
                        proguardFiles(
                            getDefaultProguardFile(BuildTypeConfig.Config.PROGUARD_ANDROID),
                            BuildTypeConfig.Config.PROGUARD_RULES
                        )
                        signingConfig = signingConfigs.getByName("release")
                    }
                }

                flavorDimensionList.add("flavors")
                productFlavors {
                    create("dev") {
                        val buildType = BuildTypeConfig.BuildType.Dev
                        dimension = "flavors"
                        applicationIdSuffix = buildType.applicationIdSuffix

                        buildType.getBuildConfigFields().forEach { (key, value) ->
                            buildConfigField("String", key, value)
                        }
                    }

                    create("staging") {
                        val buildType = BuildTypeConfig.BuildType.Staging
                        dimension = "flavors"
                        applicationIdSuffix = buildType.applicationIdSuffix

                        buildType.getBuildConfigFields().forEach { (key, value) ->
                            buildConfigField("String", key, value)
                        }
                    }

                    create("product") {
                        val buildType = BuildTypeConfig.BuildType.Product
                        dimension = "flavors"

                        buildType.getBuildConfigFields().forEach { (key, value) ->
                            buildConfigField("String", key, value)
                        }
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