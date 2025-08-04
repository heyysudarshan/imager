plugins {
    alias(libs.plugins.kotlin.compiler) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.kotlin.spring.boot) apply false
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/RootProject"))