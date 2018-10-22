pluginManagement {

    resolutionStrategy {
        eachPlugin {
            useModule(when (requested.id.id) {
                "kotlin-multiplatform", "kotlin-android", "kotlin-android-extensions", "kotlin-kapt", "org.jetbrains.kotlin.kapt" -> {
                    "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
                }
                "com.android.library", "com.android.application" -> {
                    "com.android.tools.build:gradle:${Versions.android_gradle_version}"
                }
                "kotlinx-serialization" -> {
                    "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin_version}"
                }
                else -> {
                    return@eachPlugin
                }
            })
        }
    }
}


enableFeaturePreview("GRADLE_METADATA")

include(":sharedLib")
include (":androidApp")
