package test.kmp.compose.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog

@Composable
fun PlatformDialog(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        undecorated = true,
        onCloseRequest = {
            onDismiss()
        },
        content = {
            content()
        }
    )
}
