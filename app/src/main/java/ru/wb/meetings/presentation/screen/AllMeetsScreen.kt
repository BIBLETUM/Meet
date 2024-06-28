package ru.wb.meetings.presentation.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.wb.meetings.presentation.components.SearchBar
import ru.wb.meetings.presentation.theme.MeetsTheme

@Preview
@Composable
fun AllMeetsScreen(paddingValues: PaddingValues = PaddingValues(0.dp)) {
    val allMeetsText = "ВСЕ ВСТРЕЧИ"
    val activeMeetsText = "АКТИВНЫЕ"
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = MeetsTheme.colors.neutralWhite),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 24.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            var selectedTab by remember { mutableStateOf(allMeetsText) }
            SegmentButton(text = allMeetsText, selected = selectedTab == allMeetsText, onClick = {
                selectedTab = allMeetsText
            })
            SegmentButton(
                text = activeMeetsText,
                selected = selectedTab == activeMeetsText,
                onClick = {
                    selectedTab = activeMeetsText
                })
        }
    }
}

@Composable
fun RowScope.SegmentButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    selected: Boolean,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier
            .height(48.dp)
            .weight(1f)
            .clickable(interactionSource = interactionSource, indication = null) {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val textColor = if (selected) MeetsTheme.colors.brandDefault else Color(0xFF666666)
        val separatorColor = if (selected) MeetsTheme.colors.brandDefault else Color.Transparent
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Text(
                text = text,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.84.sp,
                color = textColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(separatorColor)
                .height(2.dp)
        ) {

        }
    }
}
