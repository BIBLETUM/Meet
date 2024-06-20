package ru.wb.meetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.wb.meetings.components.ButtonPrimaryInitial
import ru.wb.meetings.components.Chip
import ru.wb.meetings.components.GhostFocus
import ru.wb.meetings.components.GhostHover
import ru.wb.meetings.components.GhostInitial
import ru.wb.meetings.components.MeetingAvatar
import ru.wb.meetings.components.ProfileAvatar
import ru.wb.meetings.components.SearchBar
import ru.wb.meetings.components.SecondaryFocus
import ru.wb.meetings.components.SecondaryHover
import ru.wb.meetings.components.SecondaryInitial
import ru.wb.meetings.ui.theme.BodyText1
import ru.wb.meetings.ui.theme.BodyText2
import ru.wb.meetings.ui.theme.Heading1
import ru.wb.meetings.ui.theme.Heading2
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.theme.Metadata1
import ru.wb.meetings.ui.theme.Metadata2
import ru.wb.meetings.ui.theme.Metadata3
import ru.wb.meetings.ui.theme.NeutralColorActive
import ru.wb.meetings.ui.theme.Subheading1
import ru.wb.meetings.ui.theme.Subheading2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeetTheme {
                LazyColumn(
                    modifier = Modifier.background(color = Color.White),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    item {
                        CustomButtons()
                    }
                    item {
                        Fonts()
                    }
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            ProfileAvatar()
                        }

                    }
                    item {
                        SearchBar()
                    }
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            MeetingAvatar()
                        }
                    }
                    item {
                        Chips()
                    }
                }
            }
        }
    }
}


@Composable
fun CustomButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ButtonPrimaryInitial(onClick = {})
        SecondaryInitial(onClick = {})
        GhostInitial(onClick = {})

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        ButtonPrimaryInitial(onClick = {}, hovered = true)
        SecondaryHover(onClick = {})
        GhostHover(onClick = {})

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        ButtonPrimaryInitial(onClick = {}, focused = true)
        SecondaryFocus(onClick = {})
        GhostFocus(onClick = {})

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        ButtonPrimaryInitial(onClick = {}, enabled = false)
        SecondaryInitial(onClick = {}, enabled = false)
        GhostInitial(onClick = {}, enabled = false)

    }
}

@Composable
fun Fonts() {
    Column(
        Modifier
            .background(color = Color.White)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        RowOfFont("Heading 1", MaterialTheme.typography.Heading1, "SF Pro Display/32/Bold")

        RowOfFont("Heading 2", MaterialTheme.typography.Heading2, "SF Pro Display/24/Bold")

        RowOfFont("Subheading 1", MaterialTheme.typography.Subheading1, "SF Pro Display18/SemiBold")

        RowOfFont("Subheading 2", MaterialTheme.typography.Subheading2, "SF Pro Display16/SemiBold")

        RowOfFont("Body Text 1", MaterialTheme.typography.BodyText1, "SF Pro Display14/SemiBold")

        RowOfFont("Body Text 2", MaterialTheme.typography.BodyText2, "SF Pro Display14/Regular")

        RowOfFont("Meta data 1", MaterialTheme.typography.Metadata1, "SF Pro Display12/Regular")

        RowOfFont("Meta data 2", MaterialTheme.typography.Metadata2, "SF Pro Display10/Regular")

        RowOfFont("Meta data 3", MaterialTheme.typography.Metadata3, "SF Pro Display10/SemiBold")
    }
}

@Composable
fun RowOfFont(styleString: String, style: TextStyle, textDesc: String) {
    val text = "The quick brown fox jumps over the lazy dog"
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.width(110.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = styleString,
                style = MaterialTheme.typography.Subheading1,
                color = NeutralColorActive
            )
            Text(
                text = textDesc,
                style = MaterialTheme.typography.BodyText2,
                color = NeutralColorActive
            )
        }
        Text(text = text, style = style, color = NeutralColorActive)
    }
    HorizontalDivider()
}


@Composable
fun Chips() {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Chip(text = "Python")
        Chip(text = "Junior")
        Chip(text = "Moscow")
    }
}