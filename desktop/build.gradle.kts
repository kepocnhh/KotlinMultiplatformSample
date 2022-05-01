import org.jetbrains.compose.desktop.application.dsl.TargetFormat

repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose") version Version.compose
}

kotlin {
    jvm(name) {
        compilations.all {
            kotlinOptions.jvmTarget = Version.jvmTarget
        }

        sourceSets {
            val sourceSet = create("main") {
                dependencies {
                    implementation(compose.desktop.currentOs)
                    implementation("org.jetbrains.compose.ui:ui-desktop:${Version.compose}")
                }
            }
            get("${name}Main").dependsOn(sourceSet)
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
