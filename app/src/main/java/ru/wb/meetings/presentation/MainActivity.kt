package ru.wb.meetings.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.meetings.presentation.components.AvatarsList
import ru.wb.meetings.presentation.components.CommunityCard
import ru.wb.meetings.presentation.components.EventCard
import ru.wb.meetings.presentation.components.ProfileAvatar
import ru.wb.meetings.presentation.components.ProfileAvatarWithBadge
import ru.wb.meetings.presentation.theme.MeetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeetsTheme {
                LazyColumn(
                    modifier = Modifier.background(color = Color.White),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
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