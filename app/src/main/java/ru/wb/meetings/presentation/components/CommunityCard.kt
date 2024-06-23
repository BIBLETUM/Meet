package ru.wb.meetings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.domain.CommunityItem
import ru.wb.meetings.presentation.theme.MeetsTheme
import java.util.Locale

@Preview
@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    communityCardItem: CommunityItem = CommunityItem(id = 0),
) {
    Column(modifier = modifier.background(Color.White)) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SquareMeetAvatar(modifier = Modifier.padding(4.dp), imageResId = communityCardItem.communityImage)

            Column(modifier = Modifier.weight(1f)) {
                Box(modifier = Modifier.height(24.dp), contentAlignment = Alignment.Center) {
                    Text(
                        text = communityCardItem.communityName,
                        style = MeetsTheme.typography.bodyText1,
                        color = MeetsTheme.colors.neutralActive,
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
                            "%,d человек",
                            communityCardItem.communitySubscribersCount
                        ),
                        style = MeetsTheme.typography.metadata1,
                        color = MeetsTheme.colors.neutralDisabled,
                        modifier = Modifier.height(20.dp)
                    )
                }
            }
        }
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp), color = MeetsTheme.colors.neutralLine)
    }
}