import com.android.build.gradle.LibraryExtension
import com.hahomework.config.BuildTypeConfig
import com.hahomework.config.BuildTypeConfig.getBuildConfigFields
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryFlavorsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                buildFeatures {
                    buildConfig = true
                }
                
                flavorDimensionList.add("flavors")
                productFlavors {
                    create("dev") {
                        val buildType = BuildTypeConfig.BuildType.Dev
                        dimension = "flavors"
                        
                        buildType.getBuildConfigFields().forEach { (key, value) ->
                            buildConfigField("String", key, value)
                        }
                    }
                    
                    create("staging") {
                        val buildType = BuildTypeConfig.BuildType.Staging
                        dimension = "flavors"
                        
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
            }
        }
    }
} 