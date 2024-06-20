package ru.wb.meetings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import ru.wb.meetings.ui.theme.BrandColorBackground
import ru.wb.meetings.ui.theme.BrandColorDark
import ru.wb.meetings.ui.theme.Metadata3

@Composable
fun Chip(
    text: String = "Python",
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(20.dp)
            .clip(shape = RoundedCornerShape(40.dp))
            .background(color = BrandColorBackground)
    ) {
        Text(
            text = text,
            color = BrandColorDark,
            style = MaterialTheme.typography.Metadata3,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 2.dp)
        )
    }
}