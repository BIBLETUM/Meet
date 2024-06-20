package ru.wb.meetings.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
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
fun MeetingAvatar(imageResId: Int = R.drawable.meeting_image_placeholder) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "",
        modifier = Modifier
            .padding(4.dp)
            .size(48.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}