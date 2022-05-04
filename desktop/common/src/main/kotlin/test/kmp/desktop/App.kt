package test.kmp.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import test.kmp.compose.presentation.module.NoteList
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import test.kmp.compose.presentation.util.Theme

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            state = rememberWindowState(),
            title = "test.kmp.desktop"
        ) {
            Theme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Theme.colors.background)
                ) {
                    NoteList.Screen()
                }
            }
        }
    }
}
