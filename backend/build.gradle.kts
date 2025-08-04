plugins {
    alias(libs.plugins.kotlin.compiler)
}

group = libs.versions.backend.group.get()
version = libs.versions.backend.version.get()

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/Backend"))