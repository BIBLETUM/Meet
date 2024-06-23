package ru.wb.meetings.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.presentation.theme.MeetsTheme

@Preview
@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String = "Button",
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    hovered: Boolean = false,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val backgroundColor = if (isHovered || hovered) {
        MeetsTheme.colors.brandDark
    } else {
        MeetsTheme.colors.brandDefault
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable(
                interactionSource,
                indication = rememberRipple(),
                enabled
            ) {
                onClick()
            }
            .background(if (enabled) backgroundColor else MeetsTheme.colors.brandDefault.copy(alpha = 0.5f))
            .height(52.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            modifier = Modifier.padding(horizontal = 48.dp, vertical = 12.dp),
            text = text,
            style = MeetsTheme.typography.subheading2,
            color = if (enabled) MeetsTheme.colors.neutralOffWhite else MeetsTheme.colors.neutralOffWhite.copy(
                alpha = 0.5f
            )
        )
    }

}

@Preview
@Composable
fun ButtonSecondary(
    modifier: Modifier = Modifier,
    text: String = "Button",
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    hovered: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val backgroundColor = if (isHovered || hovered) {
        MeetsTheme.colors.brandDark
    } else {
        MeetsTheme.colors.brandDefault
    }

    val borderStroke = if (enabled) {
        BorderStroke(2.dp, backgroundColor)
    } else {
        BorderStroke(2.dp, MeetsTheme.colors.brandDefault.copy(alpha = 0.5f))
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .border(borderStroke, RoundedCornerShape(30.dp))
            .clickable(interactionSource, indication = rememberRipple(), enabled) {
                onClick()
            }
            .background(Color.Transparent)
            .height(52.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 48.dp, vertical = 12.dp),
            text = text,
            style = MeetsTheme.typography.subheading2,
            color = if (enabled) backgroundColor else MeetsTheme.colors.brandDefault.copy(alpha = 0.5f)
        )
    }

}

@Preview
@Composable
fun ButtonGhost(
    modifier: Modifier = Modifier,
    text: String = "Button",
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    hovered: Boolean = false,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val backgroundColor = if (isHovered || hovered) {
        MeetsTheme.colors.brandDark
    } else {
        MeetsTheme.colors.brandDefault
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable(interactionSource, indication = rememberRipple(), enabled) {
                onClick()
            }
            .background(Color.Transparent)
            .height(52.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 48.dp, vertical = 12.dp),
            text = text,
            style = MeetsTheme.typography.subheading2,
            color = if (enabled) backgroundColor else MeetsTheme.colors.brandDefault.copy(alpha = 0.5f)
        )

    }
}