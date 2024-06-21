package ru.wb.meetings.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.wb.meetings.domain.EventItem
import ru.wb.meetings.presentation.components.AvatarsList
import ru.wb.meetings.presentation.components.ButtonGhost
import ru.wb.meetings.presentation.components.ButtonPrimary
import ru.wb.meetings.presentation.components.ButtonSecondary
import ru.wb.meetings.presentation.components.Chip
import ru.wb.meetings.presentation.components.CommunityCard
import ru.wb.meetings.presentation.components.EventCard
import ru.wb.meetings.presentation.components.ProfileAvatar
import ru.wb.meetings.presentation.components.ProfileAvatarWithBadge
import ru.wb.meetings.presentation.theme.BodyText1
import ru.wb.meetings.presentation.theme.BodyText2
import ru.wb.meetings.presentation.theme.Heading1
import ru.wb.meetings.presentation.theme.Heading2
import ru.wb.meetings.presentation.theme.MeetTheme
import ru.wb.meetings.presentation.theme.Metadata1
import ru.wb.meetings.presentation.theme.Metadata2
import ru.wb.meetings.presentation.theme.Metadata3
import ru.wb.meetings.presentation.theme.NeutralColorActive
import ru.wb.meetings.presentation.theme.Subheading1
import ru.wb.meetings.presentation.theme.Subheading2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeetTheme {
                LazyColumn(
                    modifier = Modifier.background(color = Color.White),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        EventCard()
                    }
                    item {
                        AvatarsList()
                    }
                    item {
                        CommunityCard()

                    }
                    item {
                        ProfileAvatar()
                    }
                    item {
                        ProfileAvatarWithBadge()
                    }
                }
            }
        }
    }
}