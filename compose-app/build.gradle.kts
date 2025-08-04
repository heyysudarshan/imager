plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/ComposeApp"))