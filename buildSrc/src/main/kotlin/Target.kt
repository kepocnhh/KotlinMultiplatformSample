import org.gradle.TaskExecutionRequest

enum class Target {
    CLI, DESKTOP, ANDROID
}

fun TaskExecutionRequest.getTargetOrNull(): Target? {
    if (args.isEmpty()) return Target.ANDROID
    val arg = args.firstOrNull() ?: error("Impossible!")
    when {
        arg.startsWith("cli:") -> return Target.CLI
        arg.startsWith("desktop:") -> return Target.DESKTOP
        "^:?android:\\w+".toRegex().matches(arg) -> return Target.ANDROID
    }
    return null
}

fun TaskExecutionRequest.onTarget(block: (Target) -> Unit) {
    val target = getTargetOrNull()
    if (target != null) block(target)
}
