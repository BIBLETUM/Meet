package ru.wb.meetings.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.presentation.components.ButtonPrimary

@Preview
@Composable
fun MoreScreen(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    navigateToMyMeets: () -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
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