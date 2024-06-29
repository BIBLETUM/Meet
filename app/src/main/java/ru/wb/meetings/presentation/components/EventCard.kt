package ru.wb.meetings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.domain.EventItem
import ru.wb.meetings.presentation.theme.MeetsTheme
import java.util.Locale

@Preview
@Composable
fun EventCard(
    modifier: Modifier = Modifier,
    eventItem: EventItem = EventItem(),
    onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier
            .background(Color.White)
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple()
            ) { onClick() }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SquareMeetAvatar(Modifier.padding(4.dp), imageResId = eventItem.meetingImage)

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
                            style = MeetsTheme.typography.bodyText1,
                            color = MeetsTheme.colors.neutralActive,
                        )
                    }
                    Text(
                        text = eventItem.status,
                        style = MeetsTheme.typography.metadata1,
                        color = MeetsTheme.colors.neutralWeak
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
                        style = MeetsTheme.typography.metadata1,
                        color = MeetsTheme.colors.neutralDisabled,
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
        HorizontalDivider(
            modifier = Modifier.padding(top = 12.dp),
            color = MeetsTheme.colors.neutralLine
        )
    }
}