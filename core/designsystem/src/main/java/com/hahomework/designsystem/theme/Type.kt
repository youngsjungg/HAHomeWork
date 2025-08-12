package com.hahomework.designsystem.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import core.designsystem.R


object Fonts {
    val Pretendard = FontFamily(
        Font(R.font.pretendard_thin, FontWeight.W100),
        Font(R.font.pretendard_extralight, FontWeight.W200),
        Font(R.font.pretendard_light, FontWeight.W300),
        Font(R.font.pretendard_regular, FontWeight.W400),
        Font(R.font.pretendard_medium, FontWeight.W500),
        Font(R.font.pretendard_semibold, FontWeight.W600),
        Font(R.font.pretendard_bold, FontWeight.W700),
        Font(R.font.pretendard_extrabold, FontWeight.W800),
        Font(R.font.pretendard_black, FontWeight.W900),
    )
}


data class Typhography(
    val fontR50: TextStyle = TextStyle(
        lineHeight = 16.sp,
        fontSize = 12.sp,
        letterSpacing = (-0.03).sp,
        fontStyle = FontStyle(R.font.pretendard_black)
    )
)