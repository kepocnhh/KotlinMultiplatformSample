repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
//    macosArm64 {
//        binaries {
//            executable {
//                entryPoint = "test.kmp.cli.main"
//            }
//        }
//
//        sourceSets {
//            val sourceSet = create("main") {
//                dependencies {
//                    // todo
//                }
//            }
//            get("${name}Main").dependsOn(sourceSet)
//        }
//    }

    val sourceSet = sourceSets.create("main") {
        dependencies {
            // todo
        }
    }

    setOf(macosArm64(), linuxX64()).forEach { target ->
        target.binaries.executable {
            entryPoint = "test.kmp.cli.main"
        }
        sourceSets["${target.name}Main"].dependsOn(sourceSet)
    }
}
