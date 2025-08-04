import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.compiler)
}

group = libs.versions.backend.group.get()
version = libs.versions.backend.version.get()

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of("21"))
    }
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin.compilerOptions {
    jvmTarget = JvmTarget.JVM_21
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/Backend"))