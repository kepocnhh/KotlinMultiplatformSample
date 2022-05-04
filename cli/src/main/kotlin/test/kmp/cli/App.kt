package test.kmp.cli

import test.kmp.common.implementation.NoteProvider

private fun printHelp() {
    println("""
        -l: print all notes
        --help: print the help
    """.trimIndent())
}

fun main(args: Array<String>) {
    when {
        args.size == 1 -> {
            val arg = args.single()
            when (arg) {
                "-l" -> {
                    val text = NoteProvider
                        .getNotes()
                        .mapIndexed { index, item -> "$index] ${item.text}" }
                        .joinToString(separator = "\n")
                    println(text)
                    return
                }
            }
        }
    }
    printHelp()
}
