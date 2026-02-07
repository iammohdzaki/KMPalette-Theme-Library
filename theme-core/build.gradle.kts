@file:OptIn(ExperimentalWasmDsl::class)

import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.maven.publish)
}

group = "io.github.iammohdzaki.kmpalette"
version = findProperty("version") as String? ?: "0.0.5"

android {
    namespace = "com.zaki.dynamic.theme"
    compileSdk = 35
    defaultConfig { minSdk = 24 }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    applyDefaultHierarchyTemplate()
    jvm("desktop")
    wasmJs()
    jvmToolchain(17)
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(libs.coroutines.core)
                implementation(libs.serialization.json)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), project.name, version.toString())

    pom {
        name = project.name
        description.set("Kotlin Multiplatform library for themes")
        url.set("https://github.com/iammohdzaki/KMP-Dynamic-Theme-Library")
        inceptionYear = "2025"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "iammohdzaki"
                name = "Mohammad Zaki"
                url = "https://github.com/iammohdzaki"
            }
        }
        scm {
            url = "https://github.com/iammohdzaki/KMP-Dynamic-Theme-Library"
            connection = "scm:git:git://github.com/iammohdzaki/KMP-Dynamic-Theme-Library.git"
            developerConnection = "scm:git:ssh://git@github.com/iammohdzaki/KMP-Dynamic-Theme-Library.git"
        }
    }
}