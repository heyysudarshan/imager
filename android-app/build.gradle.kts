plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.androidApp.group.get()
version = libs.versions.androidApp.version.get()

android {
    namespace = libs.versions.androidApp.namespace.get()
    compileSdk = libs.versions.androidApp.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.androidApp.applicationId.get()
        minSdk = libs.versions.androidApp.minSdk.get().toInt()
        targetSdk = libs.versions.androidApp.targetSdk.get().toInt()
        versionCode = libs.versions.androidApp.versionCode.get().toInt()
        versionName = libs.versions.androidApp.versionName.get()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
    }
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/AndroidApp"))