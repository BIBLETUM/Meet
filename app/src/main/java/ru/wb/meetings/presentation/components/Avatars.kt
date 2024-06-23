package ru.wb.meetings.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R

@Preview
@Composable
fun ProfileAvatar(
    modifier: Modifier = Modifier,
    imageResId: Int = R.drawable.profile_image_placeholder,
) {
    Box(modifier = modifier.size(200.dp), content = {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .fillMaxSize()
        )
    })
}

@Preview
@Composable
fun ProfileAvatarWithBadge(
    modifier: Modifier = Modifier,
    imageResId: Int = R.drawable.profile_image_placeholder,
    badgeResId: Int = R.drawable.plus_icon,
    onClick: () -> Unit = {}
) {
    Box(modifier = modifier.size(100.dp), contentAlignment = Alignment.BottomEnd) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .fillMaxSize()
        )
        Image(
            painter = painterResource(badgeResId),
            contentDescription = "",
            modifier = Modifier
                .padding(1.dp)
                .size(20.dp)
                .offset(x = (-3).dp, y = (-1).dp)
        )
    }

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

@Composable
fun UserAvatar(modifier: Modifier = Modifier, imageResId: Int = R.drawable.user_placeholder) {
    Avatar(
        modifier
            .border(BorderStroke(2.dp, Color(0xFFD2D5F9)), RoundedCornerShape(16.dp)),
        imageResId = imageResId
    )
}