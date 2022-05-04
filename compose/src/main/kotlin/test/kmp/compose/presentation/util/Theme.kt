package test.kmp.compose.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dimensions(val item: Item) {
    companion object {
        val local = staticCompositionLocalOf { Dimensions(Item(height = 48.dp)) }
    }

    class Item(val height: Dp)
}

sealed class Colors(
    val primary: Color,
    val background: Color,
    val text: Color,
    val divider: Color,
    val error: Color
) {
    object Light : Colors(
        primary = Color(0xff3174d8),
        background = white,
        text = black,
        divider = Color(0xffcdced2),
        error = Color(0xffff6368)
    )

    companion object {
        val black = Color(0xff000000)
        val transparent = Color(0x00000000)
        val white = Color(0xffffffff)
        val local = staticCompositionLocalOf<Colors> { Light }
    }
}

object Theme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = Colors.local.current

    val dimensions: Dimensions
        @Composable
        @ReadOnlyComposable
        get() = Dimensions.local.current
}

@Composable
fun Theme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        Dimensions.local provides Dimensions(Dimensions.Item(height = 48.dp)),
        Colors.local provides Colors.Light,
        content = content
    )
}
