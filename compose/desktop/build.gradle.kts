repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(project(":common"))
    implementation("org.jetbrains.compose.foundation:foundation:${Version.compose}")
}
