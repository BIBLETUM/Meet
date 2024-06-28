package ru.wb.meetings.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.wb.meetings.R
import ru.wb.meetings.presentation.components.IconButtonSecondary
import ru.wb.meetings.presentation.components.ProfileAvatar
import ru.wb.meetings.presentation.theme.MeetsTheme

@Preview
@Composable
fun ProfileScreen(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    userName: String = "Иван Иванов",
    userNumber: String = "+7 999 999-99-99"
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(top = 47.dp))
        ProfileAvatar()
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = userName,
            style = MeetsTheme.typography.subheading1.copy(
                fontSize = 24.sp,
                color = MeetsTheme.colors.neutralActive
            )
        )
        Spacer(modifier = Modifier.padding(top = 4.dp))
        Text(
            text = userNumber,
            style = MeetsTheme.typography.bodyText2.copy(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = MeetsTheme.colors.neutralDisabled
            )
        )
        Spacer(modifier = Modifier.padding(top = 40.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            IconButtonSecondary(iconResId = R.drawable.x_icon, contentDescription = "X")
            IconButtonSecondary(
                iconResId = R.drawable.instagram_icon,
                contentDescription = "Instagram"
            )
            IconButtonSecondary(
                iconResId = R.drawable.linkedin_icon,
                contentDescription = "linkedin"
            )
            IconButtonSecondary(
                iconResId = R.drawable.facebook_icon,
                contentDescription = "facebook"
            )
        }
    }

}