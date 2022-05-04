repositories {
    mavenCentral()
    google()
}

plugins {
    id("com.android.library")
    id("kotlin-android")
}

dependencies {
    implementation("androidx.compose.foundation:foundation:${Version.compose}")
}

apply(from = File(rootDir, "android/library.kts"))
