package ru.wb.meetings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.presentation.theme.MeetsTheme

@Preview
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    CustomTextField(
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                null,
                tint = MeetsTheme.colors.neutralDisabled
            )
        },
        modifier = modifier
            .background(
                MeetsTheme.colors.neutralOffWhite,
                RoundedCornerShape(4.dp)
            )
            .height(36.dp),
        placeholderText = "Поиск"
    )
}

@Composable
private fun CustomTextField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Placeholder"
) {
    var text by rememberSaveable { mutableStateOf("") }
    BasicTextField(modifier = modifier
        .background(
            MeetsTheme.colors.neutralOffWhite,
            ShapeDefaults.Small,
        )
        .fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        textStyle = MeetsTheme.typography.bodyText1,
        decorationBox = { innerTextField ->
            Row(
                Modifier.padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) Text(
                        placeholderText,
                        style = MeetsTheme.typography.bodyText1,
                        color = MeetsTheme.colors.neutralDisabled
                    )
                    innerTextField()
                }
            }
        }
    )
}