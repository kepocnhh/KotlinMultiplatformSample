repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
    macosArm64 {
        binaries {
            executable {
                entryPoint = "test.kmp.cli.main"
            }
        }

        sourceSets {
            val sourceSet = create("main") {
                dependencies {
                    // todo
                }
            }
            get("${name}Main").dependsOn(sourceSet)
        }
    }
}
