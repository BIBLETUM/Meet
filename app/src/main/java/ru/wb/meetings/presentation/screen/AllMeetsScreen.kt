package ru.wb.meetings.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.presentation.components.SearchBar
import ru.wb.meetings.presentation.theme.MeetsTheme

@Preview
@Composable
fun AllMeetsScreen(paddingValues: PaddingValues = PaddingValues(0.dp)) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = MeetsTheme.colors.neutralWhite)
    ) {
        Spacer(modifier = Modifier.padding(top = 16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 24.dp))
    }
}