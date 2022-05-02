repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.compose") version Version.compose
}

dependencies {
    implementation(compose.desktop.common)
}
