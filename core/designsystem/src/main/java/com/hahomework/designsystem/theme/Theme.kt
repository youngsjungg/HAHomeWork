package com.hahomework.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = HaColor.Gray100,
    onPrimary = HaColor.Gray900,
    secondary = HaColor.Gray300,
    onSecondary = HaColor.Gray800,
    background = HaColor.Gray900,
    onBackground = HaColor.Gray100,
    surface = HaColor.Gray800,
    onSurface = HaColor.Gray100,
)

private val LightColorScheme = lightColorScheme(
    primary = HaColor.Gray900,
    onPrimary = HaColor.White,
    secondary = HaColor.Gray600,
    onSecondary = HaColor.White,
    background = HaColor.Background,
    onBackground = HaColor.OnBackground,
    surface = HaColor.Surface,
    onSurface = HaColor.OnSurface,
)

val LocalDarkTheme = compositionLocalOf { true }

@Composable
fun HaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    if (!LocalInspectionMode.current) {
        val view = LocalView.current
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalDarkTheme provides darkTheme,
        LocalTypography provides Typography,
        LocalShape provides HaShape(),
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

object HaTheme {
    val typography: HaTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shape: HaShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShape.current

    val colors: androidx.compose.material3.ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme

    val isDarkTheme: Boolean
        @Composable
        get() = LocalDarkTheme.current
}
