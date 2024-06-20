package ru.wb.meetings.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.wb.meetings.R

val sfFontFamily = FontFamily(
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val Typography.Heading1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    }

val Typography.Heading2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }

val Typography.Subheading1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
    }

val Typography.Subheading2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }

val Typography.BodyText1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }

val Typography.BodyText2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
    }

val Typography.Metadata1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    }

val Typography.Metadata2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        )
    }

val Typography.Metadata3: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = sfFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp
        )
    }