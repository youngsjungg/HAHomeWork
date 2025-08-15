package com.hahomework.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp


@Stable
data class HaShape(
    val small: Shape = RoundedCornerShape(4.dp),
    val medium: Shape = RoundedCornerShape(8.dp),
    val large: Shape = RoundedCornerShape(12.dp),
    val extraLarge: Shape = RoundedCornerShape(16.dp),
    val chip: Shape = RoundedCornerShape(10.dp),
    val rounded12: Shape = RoundedCornerShape(12.dp),
)

val LocalShape = staticCompositionLocalOf { HaShape() }
