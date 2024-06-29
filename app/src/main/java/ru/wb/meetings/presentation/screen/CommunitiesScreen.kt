package ru.wb.meetings.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ru.wb.meetings.presentation.AppBarState

@Composable
fun CommunitiesScreen(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    onComposing: (AppBarState) -> Unit,
) {
    onComposing(
        AppBarState(
            title = "Сообщества",
            navigationIcon = null,
            actions = null
        )
    )
}