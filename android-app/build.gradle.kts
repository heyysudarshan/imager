plugins {
    alias(libs.plugins.android.application)
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/AndroidApp"))