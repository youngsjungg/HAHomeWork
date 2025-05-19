package com.techapps.config

/**
 * 빌드 타입별 설정을 관리하는 클래스
 */
object BuildTypeConfig {

    /**
     * 빌드 타입 정의
     */
    sealed class BuildType(
        val name: String,
        val isShrinkResources: Boolean,
        val baseUrl: String,
        val applicationIdSuffix: String? = null,
    ) {
        object Dev : BuildType(
            name = "dev",
            isShrinkResources = false,
            baseUrl = "",
            applicationIdSuffix = ".dev"
        )

        object Staging : BuildType(
            name = "staging",
            isShrinkResources = true,
            baseUrl = "",
            applicationIdSuffix = ".staging"
        )

        object Product : BuildType(
            name = "product",
            isShrinkResources = true,
            baseUrl = ""
        )
    }

    val allBuildTypes = listOf(
        BuildType.Dev,
        BuildType.Staging,
        BuildType.Product
    )

    /**
     * 빌드 타입별 공통 설정
     */
    object Config {
        const val PROGUARD_ANDROID = "proguard-android.txt"
        const val PROGUARD_RULES = "../buildSrc/proguard-rules.pro"

        object SigningConfig {
            // 임시로 추후 키스토어 생성후 수정 필요
            object Debug {
                const val STORE_FILE = "keystore/debug.keystore"
                const val KEY_ALIAS = ""
                const val STORE_PASSWORD = ""
                const val KEY_PASSWORD = ""
            }

            object Release {
                const val STORE_FILE = "keystore/apps_release.jks"
                const val KEY_ALIAS = ""
                const val STORE_PASSWORD = ""
                const val KEY_PASSWORD = ""
            }
        }

        object ResValue {
            const val TEMP_KEY = "TEMP_KEY"
        }

        object Fields {
            const val ENVIRONMENT = "ENVIRONMENT"
            const val BASE_URL = "BASE_URL"
        }
    }

    /**
     * 빌드 타입 이름으로 BuildType 객체 찾기
     */
    fun findBuildType(name: String): BuildType {
        return allBuildTypes.find { it.name == name }
            ?: BuildType.Dev
    }

    /**
     * BuildConfig 필드 생성을 위한 확장 함수
     */
    fun BuildType.getBuildConfigFields(): Map<String, String> {
        return mapOf(
            Config.Fields.ENVIRONMENT to "\"${name}\"",
            Config.Fields.BASE_URL to "\"$baseUrl\"",
        )
    }
}