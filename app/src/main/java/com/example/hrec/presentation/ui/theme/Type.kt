package com.example.hrec.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import com.example.hrec.R

// font family rubik
private val Rubik = FontFamily(
    Font(R.font.rubik_bold, FontWeight.Bold),
    Font(R.font.rubik_semibold, FontWeight.SemiBold),
    Font(R.font.rubik_regular, FontWeight.Normal),
    Font(R.font.rubik_extrabold, FontWeight.ExtraBold)
)

val RubikTypography = Typography(
    body1 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle1= TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    h1 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h3 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)