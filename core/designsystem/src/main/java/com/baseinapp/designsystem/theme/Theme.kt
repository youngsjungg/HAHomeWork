package com.baseinapp.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import com.baseinapp.designsystem.theme.BaseTheme.typhography

@Composable
fun BaseTheme(
    colors: Colors = BaseTheme.colors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides typhography,
        LocalColors provides colors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

object BaseTheme {
    val typhography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current


    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

val LocalColors = staticCompositionLocalOf { Colors() }
val LocalTypography = staticCompositionLocalOf { Typography() }