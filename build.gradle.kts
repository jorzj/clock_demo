// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlin.kapt).apply(false)
    alias(libs.plugins.jetbrainsKotlinJvm) apply false
    kotlin("plugin.serialization") version "1.9.0" apply false
}