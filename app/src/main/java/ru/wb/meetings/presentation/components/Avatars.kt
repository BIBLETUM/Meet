package ru.wb.meetings.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R

@Composable
fun ProfileAvatar(imageResId: Int = R.drawable.profile_image_placeholder) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "",
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(100.dp))
    )
}

@Composable
fun Avatar(modifier: Modifier, imageResId: Int = R.drawable.meeting_image_placeholder) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "",
        modifier = modifier
            .size(48.dp)
            .clip(RoundedCornerShape(16.dp))

    )
}

@Preview
@Composable
fun UserAvatar(modifier: Modifier = Modifier, imageResId: Int = R.drawable.user_placeholder) {
    Avatar(modifier
        .border(BorderStroke(2.dp, Color(0xFFD2D5F9)), RoundedCornerShape(16.dp)))
}