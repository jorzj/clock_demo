plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)

}

android {
    namespace = "ru.jorzj.clock_ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}
dependencies {
    implementation(project(":network"))
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation (libs.retrofit)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.decompose)
    implementation(libs.decompose.ext)
    implementation(libs.androidx.material3.android)

    implementation(libs.dagger.dagger)
    kapt(libs.dagger.daggerCompiler)
    // implementation (libs.androidx.datastore.preferences)

}