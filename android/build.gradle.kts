repositories {
    google()
    mavenCentral()
}

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = Version.android.compileSdk

    defaultConfig {
        minSdk = Version.android.minSdk
        targetSdk = Version.android.targetSdk
        versionCode = Version.Application.code
        versionName = Version.Application.name
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":compose"))
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.compose.foundation:foundation:${Version.compose}")
}
