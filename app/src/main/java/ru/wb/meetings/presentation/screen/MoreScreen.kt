package ru.wb.meetings.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.meetings.presentation.AppBarState
import ru.wb.meetings.presentation.components.ButtonPrimary

@Composable
fun MoreScreen(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    onComposing: (AppBarState) -> Unit,
    navigateToMyMeets: () -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
    onComposing(AppBarState(
        title = "Еще",
        navigationIcon = null,
        actions = null
    ))

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ButtonPrimary(text = "To MyMeets") {
            navigateToMyMeets()
        }

        ButtonPrimary(text = "To Profile") {
            navigateToProfile()
        }
    }
}