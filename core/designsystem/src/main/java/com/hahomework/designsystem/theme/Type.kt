package com.hahomework.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val SansSerifStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
)

internal val Typography = HaTypography(
    titleLarge = SansSerifStyle.copy(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 40.sp,
    ),
    titleMedium = SansSerifStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 32.sp,
    ),
    titleSmall = SansSerifStyle.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 28.sp,
    ),
    contentLarge = SansSerifStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
    ),
    contentMedium = SansSerifStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
    ),
    contentSmall = SansSerifStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 18.sp,
    ),
    labelLarge = SansSerifStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
    ),
    labelMedium = SansSerifStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 18.sp,
    ),
    labelSmall = SansSerifStyle.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 16.sp,
    ),
)

@Immutable
data class HaTypography(
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val contentLarge: TextStyle,
    val contentMedium: TextStyle,
    val contentSmall: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
)

val LocalTypography = staticCompositionLocalOf {
    HaTypography(
        titleLarge = SansSerifStyle,
        titleMedium = SansSerifStyle,
        titleSmall = SansSerifStyle,
        contentLarge = SansSerifStyle,
        contentMedium = SansSerifStyle,
        contentSmall = SansSerifStyle,
        labelLarge = SansSerifStyle,
        labelMedium = SansSerifStyle,
        labelSmall = SansSerifStyle,
    )
}

