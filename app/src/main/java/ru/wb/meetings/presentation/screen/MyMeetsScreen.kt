package ru.wb.meetings.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.domain.EventItem
import ru.wb.meetings.presentation.AppBarState
import ru.wb.meetings.presentation.components.EventCard
import ru.wb.meetings.presentation.components.SegmentButton
import ru.wb.meetings.presentation.theme.MeetsTheme

@Composable
fun MyMeetsScreen(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    onComposing: (AppBarState) -> Unit,
    navigateBack: () -> Unit,
) {
    onComposing(AppBarState(
        title = "Встречи",
        actions = null,
        navigationIcon = {
            val interactionSource = remember {
                MutableInteractionSource()
            }
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(24.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = rememberRipple()
                    ) {
                        navigateBack()
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(14.dp),
                    painter = painterResource(id = R.drawable.arrow_back_icon),
                    contentDescription = "Назад",
                    tint = MeetsTheme.colors.neutralActive
                )
            }
        }
    ))

    val allMeetsText = "ЗАПЛАНИРОВАНО"
    val activeMeetsText = "ПРОШЛИ"
    Column(
        modifier = Modifier
            .background(color = MeetsTheme.colors.neutralWhite)
            .padding(top = 16.dp)
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            var selectedTab by remember { mutableStateOf(allMeetsText) }
            SegmentButton(
                text = allMeetsText,
                selected = selectedTab == allMeetsText,
                onClick = {
                    selectedTab = allMeetsText
                }
            )
            SegmentButton(
                text = activeMeetsText,
                selected = selectedTab == activeMeetsText,
                onClick = {
                    selectedTab = activeMeetsText
                })
        }
        val meetsList = mutableListOf<EventItem>()
        for (i in 0..50) {
            meetsList.add(EventItem(id = i))
        }

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = meetsList, key = { item: EventItem -> item.id }) { eventItem ->
                EventCard(eventItem = eventItem)
            }
        }
    }
}