plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/AndroidApp"))