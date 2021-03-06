repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(project(":common"))
    implementation(project(":compose"))
    implementation(compose.desktop.common)
}
