package test.kmp.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import test.kmp.compose.presentation.module.NoteList
import test.kmp.compose.presentation.util.Theme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
