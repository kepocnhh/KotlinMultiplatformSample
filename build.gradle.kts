buildscript {
    repositories.mavenCentral()

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}")
        gradle.startParameter.taskRequests.firstOrNull()?.onTarget { target ->
            when (target) {
                Target.ANDROID -> {
                    repositories.google()
                    classpath("com.android.tools.build:gradle:7.1.3")
                }
                Target.DESKTOP -> {
                    classpath("org.jetbrains.compose:compose-gradle-plugin:${Version.compose}")
                }
            }
        }
    }
}

task<Delete>("clean") {
    delete = setOf(rootProject.buildDir, "buildSrc/build")
}
