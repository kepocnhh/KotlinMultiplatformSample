when (val target = gradle.startParameter.taskRequests.firstOrNull()?.getTargetOrNull()) {
    Target.DESKTOP -> {
        repositories.mavenCentral()
        apply(plugin = "org.jetbrains.kotlin.jvm")
        apply(plugin = "org.jetbrains.compose")
        dependencies {
            "implementation"(project(":common"))
            "implementation"(project(":compose:desktop"))
            "implementation"("org.jetbrains.compose.foundation:foundation:${Version.compose}")
        }
    }
    Target.ANDROID -> {
        repositories {
            mavenCentral()
            google()
        }
        apply(plugin = "com.android.library")
        apply(plugin = "kotlin-android")
        apply(from = File(rootDir, "android/library.kts"))
        dependencies {
            "implementation"(project(":common"))
            "implementation"(project(":compose:android"))
            "implementation"("androidx.compose.foundation:foundation:${Version.compose}")
        }
    }
    else -> error("Target $target is not supported!")
}
