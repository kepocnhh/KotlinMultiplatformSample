import org.jetbrains.compose.desktop.application.dsl.TargetFormat

repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose") version "1.1.1"
}

val jvmTarget = "1.8"

kotlin {
    jvm("desktop") {
        val target = name
        compilations.all {
            kotlinOptions.jvmTarget = jvmTarget
        }
        sourceSets {
            val main = create("main") {
                dependencies {
                    implementation(compose.desktop.currentOs)
                    implementation("org.jetbrains.compose.ui:ui-desktop:1.1.1")
                }
            }
            get("${target}Main").dependsOn(main)
        }
    }
}

compose.desktop {
    application {
        mainClass = "test.kmp.desktop.AppKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg) // TargetFormat.Msi, TargetFormat.Deb
            packageName = "test.kmp.desktop"
//            packageVersion = "0.0.1"
        }
    }
}
