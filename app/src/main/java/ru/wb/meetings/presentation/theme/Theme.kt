package ru.wb.meetings.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

@Composable
fun MeetsTheme(
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColorScheme provides LightColorScheme,
        LocalTypography provides MeetsTypographyValue,
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object MeetsTheme {
    val colors: MeetsColorScheme
        @Composable get() = LocalColorScheme.current
    val typography: MeetsTypography
        @Composable get() = LocalTypography.current
}