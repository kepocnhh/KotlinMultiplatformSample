package test.kmp.desktop

import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import test.kmp.common.Foo

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            state = rememberWindowState(),
            title = "test.kmp.desktop"
        ) {
            BasicText(
                text = "Hello (${Foo.getBar()}) desktop!"
            )
            // todo
        }
    }
}
