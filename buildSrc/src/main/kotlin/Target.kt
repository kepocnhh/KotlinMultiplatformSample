import org.gradle.TaskExecutionRequest

enum class Target {
    CLI, DESKTOP, ANDROID
}

fun TaskExecutionRequest.onTarget(block: (Target) -> Unit) {
    if (args.isEmpty()) {
        block(Target.ANDROID)
        return
    }
    if (args.size != 1) error("Args ${args.size} $args is not supported!")
    val arg = args.single()
    when {
        arg.startsWith("cli:") -> block(Target.CLI)
        arg.startsWith("desktop:") -> block(Target.DESKTOP)
        "^:?android:\\w+".toRegex().matches(arg) -> block(Target.ANDROID)
    }
}
