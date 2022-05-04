import org.jetbrains.compose.desktop.application.dsl.TargetFormat

repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(project(":desktop:common"))
    implementation(compose.desktop.macos_arm64)
}

compose.desktop {
    application {
        mainClass = "test.kmp.desktop.AppKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg)
            packageName = "test.kmp.desktop"
//            packageVersion = "0.0.1"
        }
    }
}
