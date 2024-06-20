package ru.wb.meetings.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.BrandColorBackground
import ru.wb.meetings.ui.theme.BrandColorDark
import ru.wb.meetings.ui.theme.BrandColorDefault
import ru.wb.meetings.ui.theme.NeutralColorLine
import ru.wb.meetings.ui.theme.NeutralColorOffWhite
import ru.wb.meetings.ui.theme.Subheading2


@Preview
@Composable
fun ButtonPrimaryInitial(
    text: String = "Button",
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    hovered: Boolean = false,
    focused: Boolean = true,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()

    val rippleColor = if (isPressed || focused) BrandColorBackground else Color.Transparent

    val backgroundColor = if (isHovered || hovered) {
        BrandColorDark
    } else {
        BrandColorDefault
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(50))
            .background(rippleColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(30.dp))
                .clickable(interactionSource, indication = null, enabled) {
                    onClick()
                }
                .hoverable(interactionSource)
                .background(if (enabled) backgroundColor else BrandColorDefault.copy(alpha = 0.5f))
                .height(52.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 48.dp, vertical = 12.dp),
                text = text,
                style = MaterialTheme.typography.Subheading2,
                color = if (enabled) NeutralColorOffWhite else NeutralColorOffWhite.copy(alpha = 0.5f)
            )
        }
    }


}

@Composable
fun SecondaryInitial(text: String = "Button", onClick: () -> Unit = {}, enabled: Boolean = true) {
    val borderStroke = if (enabled) {
        BorderStroke(2.dp, BrandColorDefault)
    } else {
        BorderStroke(2.dp, BrandColorDefault.copy(alpha = 0.5f))
    }
    OutlinedButton(
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            contentColor = BrandColorDefault,
            containerColor = Color.Transparent,
            disabledContentColor = BrandColorDefault.copy(alpha = 0.5f),
            disabledContainerColor = Color.Transparent
        ),
        border = borderStroke
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 48.dp, vertical = 12.dp),
            text = text,
            style = MaterialTheme.typography.Subheading2
        )
    }
}

@Composable
fun SecondaryHover(text: String = "Button", onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            contentColor = BrandColorDark,
            containerColor = Color.Transparent
        ),
        border = BorderStroke(2.dp, BrandColorDark)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 48.dp, vertical = 12.dp),
            text = text,
            style = MaterialTheme.typography.Subheading2
        )
    }
}

@Composable
fun SecondaryFocus(text: String = "Button", onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(50))
            .background(NeutralColorOffWhite)
    ) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .padding(8.dp),
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(
                contentColor = BrandColorDefault,
                containerColor = NeutralColorOffWhite
            ),
            border = BorderStroke(2.dp, BrandColorDark)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 12.dp),
                text = text,
                style = MaterialTheme.typography.Subheading2
            )
        }
    }

}

@Composable
fun GhostInitial(text: String = "Button", onClick: () -> Unit = {}, enabled: Boolean = true) {
    TextButton(
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            contentColor = BrandColorDefault,
            containerColor = Color.Transparent,
            disabledContentColor = BrandColorDefault.copy(alpha = 0.5f),
            disabledContainerColor = Color.Transparent
        ),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 34.dp, vertical = 12.dp),
            style = MaterialTheme.typography.Subheading2,
            text = text
        )
    }
}

@Composable
fun GhostHover(text: String = "Button", onClick: () -> Unit) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            contentColor = BrandColorDark,
            containerColor = Color.Transparent
        ),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 34.dp, vertical = 12.dp),
            style = MaterialTheme.typography.Subheading2,
            text = text
        )
    }
}

@Composable
fun GhostFocus(text: String = "Button", onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(50))
            .background(NeutralColorOffWhite)
    ) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .padding(8.dp),
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(
                contentColor = BrandColorDefault,
                containerColor = NeutralColorLine
            ),
            border = BorderStroke(2.dp, BrandColorDark)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 34.dp, vertical = 12.dp),
                text = text,
                style = MaterialTheme.typography.Subheading2
            )
        }
    }
}