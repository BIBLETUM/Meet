package ru.wb.meetings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.wb.meetings.presentation.theme.MeetsTheme

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String = "Python",
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(20.dp)
            .clip(shape = RoundedCornerShape(40.dp))
            .background(color = MeetsTheme.colors.brandBackground)
    ) {
        Text(
            text = text,
            color = MeetsTheme.colors.brandDark,
            style = MeetsTheme.typography.metadata3,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 2.dp)
        )
    }
}