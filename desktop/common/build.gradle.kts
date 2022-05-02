repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.compose") version Version.compose
}

dependencies {
    implementation(project(":common"))
    implementation(compose.desktop.common)
}
