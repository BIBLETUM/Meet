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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.domain.CommunityCardItem
import ru.wb.meetings.presentation.theme.BodyText1
import ru.wb.meetings.presentation.theme.Metadata1
import ru.wb.meetings.presentation.theme.NeutralColorActive
import ru.wb.meetings.presentation.theme.NeutralColorDisabled
import ru.wb.meetings.presentation.theme.NeutralColorLine
import java.util.Locale

@Preview
@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    communityCardItem: CommunityCardItem = CommunityCardItem(id = 0),
) {
    Column(modifier = modifier.background(NeutralColorLine)) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MeetingAvatar(imageResId = communityCardItem.communityImage)

            Column(modifier = Modifier.weight(1f)) {
                Box(modifier = Modifier.height(24.dp), contentAlignment = Alignment.Center) {
                    Text(
                        text = communityCardItem.communityName,
                        style = MaterialTheme.typography.BodyText1,
                        color = NeutralColorActive,
                    )
                }

                Box(modifier = Modifier.height(20.dp), contentAlignment = Alignment.Center) {
                    Text(
                        text = String.format(
                            Locale.US,
                            "%,d человек",
                            communityCardItem.communitySubscribersCount
                        ),
                        style = MaterialTheme.typography.Metadata1,
                        color = NeutralColorDisabled,
                        modifier = Modifier.height(20.dp)
                    )
                }
            }
        }
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp))
    }
}