package ru.wb.meetings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.domain.User
import ru.wb.meetings.presentation.theme.BodyText1
import ru.wb.meetings.presentation.theme.NeutralColorActive
import java.util.Locale

@Preview
@Composable
fun AvatarsList(modifier: Modifier = Modifier, users: MutableList<User> = mutableListOf()) {
    for (i in 0..12) {
        users.add(User())
    }
    val countListedUsers = if (users.size > 5) 5 else users.size
    val leftUsers = users.size - countListedUsers
    Row(
        modifier = modifier
            .background(Color.White)
            .padding(start = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy((-15).dp),
            reverseLayout = true,
            userScrollEnabled = false
        ) {
            items(countListedUsers) { index ->
                UserAvatar(
                    modifier = Modifier.padding(vertical = 4.dp),
                    imageResId = users[index].profileImage
                )
            }
        }
        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
        if (leftUsers > 0) {
            Text(
                text = String.format(
                    Locale.US,
                    "+%s",
                    leftUsers.toString()
                ), style = MaterialTheme.typography.BodyText1,
                color = NeutralColorActive
            )
        }
    }
}