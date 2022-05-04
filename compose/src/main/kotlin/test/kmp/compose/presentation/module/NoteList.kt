package test.kmp.compose.presentation.module

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import test.kmp.common.implementation.NoteProvider
import test.kmp.compose.presentation.util.PlatformDialog
import test.kmp.compose.presentation.util.Theme

object NoteList {
    @Composable
    fun Screen() {
        var requested by remember { mutableStateOf<Int?>(null) }
        val notes = NoteProvider.getNotes()
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = rememberLazyListState()
            ) {
                items(notes.size) { index ->
                    BasicText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(Theme.dimensions.item.height)
                            .clickable {
                                requested = index
                        },
                        text = "$index] " + notes[index].text,
                        style = TextStyle(color = Theme.colors.text)
                    )
                }
            }
        }
        if (requested != null) {
            PlatformDialog(
                onDismiss = {
                    requested = null
                }
            ) {
                Column(modifier = Modifier.background(color = Theme.colors.background)) {
                    BasicText(
                        modifier = Modifier
                            .height(48.dp),
                        text = "Item #$requested clicked!",
                        style = TextStyle(color = Theme.colors.text)
                    )
                    BasicText(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable {
                                requested = null
                            },
                        text = "ok",
                        style = TextStyle(color = Theme.colors.primary)
                    )
                }
            }
        }
    }
}
