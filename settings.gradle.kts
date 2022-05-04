rootProject.name = "KotlinMultiplatformSample"

include("common")

val android = setOf("compose", "compose:android", "android")
gradle.startParameter.taskRequests.firstOrNull()?.also { taskRequest ->
    val args = taskRequest.args
    when {
        args.isEmpty() -> include(*android.toTypedArray())
        else -> {
            val arg = args.firstOrNull() ?: error("Impossible!")
            when {
                arg.startsWith("cli:") -> {
                    include("cli")
                }
                arg.startsWith("desktop:") -> {
                    include("compose", "compose:desktop", "desktop:common", "desktop:macos:arm64")
                }
                "^:?android:\\w+".toRegex().matches(arg) -> include(*android.toTypedArray())
            }
        }
    }

}
