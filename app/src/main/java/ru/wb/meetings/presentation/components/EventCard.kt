package ru.wb.meetings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.domain.EventItem
import ru.wb.meetings.presentation.theme.BodyText1
import ru.wb.meetings.presentation.theme.Metadata1
import ru.wb.meetings.presentation.theme.NeutralColorActive
import ru.wb.meetings.presentation.theme.NeutralColorDisabled
import ru.wb.meetings.presentation.theme.NeutralColorLine
import ru.wb.meetings.presentation.theme.NeutralColorWeak
import java.util.Locale

@Preview
@Composable
fun EventCard(modifier: Modifier = Modifier, eventItem: EventItem = EventItem()) {
    Column(modifier = modifier.background(Color.White)) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Avatar(Modifier.padding(4.dp), imageResId = eventItem.meetingImage)

            Column(modifier = Modifier.weight(1f)) {
                Row {
                    Box(
                        modifier = Modifier
                            .height(24.dp)
                            .weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = eventItem.meetingName,
                            style = MaterialTheme.typography.BodyText1,
                            color = NeutralColorActive,
                        )
                    }
                    Text(
                        text = eventItem.status,
                        style = MaterialTheme.typography.Metadata1,
                        color = NeutralColorWeak
                    )
                }


                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .padding(top = 2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = String.format(
                            Locale.US,
                            "%s — %s",
                            eventItem.date, eventItem.city
                        ),
                        style = MaterialTheme.typography.Metadata1,
                        color = NeutralColorDisabled,
                        modifier = Modifier.height(20.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .height(28.dp)
                        .padding(top = 2.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    eventItem.tags.forEach { chipitem ->
                        Chip(modifier = modifier.padding(vertical = 4.dp), text = chipitem)
                    }
                }
            }
        }
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp), color = NeutralColorLine)
    }
}