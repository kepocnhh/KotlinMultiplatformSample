rootProject.name = "KotlinMultiplatformSample"

include("common")

gradle.startParameter.taskRequests.firstOrNull()?.also { taskRequest ->
    val args = taskRequest.args
    when {
        args.isEmpty() -> {
            include("android")
        }
        args.size != 1 -> error("Args ${args.size} $args is not supported!")
        else -> {
            val arg = args.single()
            when {
                arg.startsWith("cli:") -> {
                    include("cli")
                }
                arg.startsWith("desktop:") -> {
                    include("desktop:common", "desktop:macos:arm64")
                }
                "^:?android:\\w+".toRegex().matches(arg) -> {
                    include("android")
                }
            }
        }
    }

}
