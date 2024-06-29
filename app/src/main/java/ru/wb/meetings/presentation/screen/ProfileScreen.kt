package ru.wb.meetings.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.wb.meetings.R
import ru.wb.meetings.presentation.AppBarState
import ru.wb.meetings.presentation.components.IconButtonSecondary
import ru.wb.meetings.presentation.components.ProfileAvatar
import ru.wb.meetings.presentation.theme.MeetsTheme

@Composable
fun ProfileScreen(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    userName: String = "Иван Иванов",
    userNumber: String = "+7 999 999-99-99",
    onComposing: (AppBarState) -> Unit,
    navigateBack: () -> Unit,
    navigateToEditProfile: () -> Unit,
) {
    onComposing(AppBarState(
        title = "Профиль",
        actions = {
            val interactionSource = remember {
                MutableInteractionSource()
            }
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = rememberRipple()
                    ) {
                        navigateToEditProfile()
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(18.dp),
                    painter = painterResource(id = R.drawable.edit_pen_icon),
                    contentDescription = "Редактировать профиль",
                    tint = MeetsTheme.colors.neutralActive
                )
            }

        },
        navigationIcon = {
            val interactionSource = remember {
                MutableInteractionSource()
            }
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(24.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = rememberRipple()
                    ) {
                        navigateBack()
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(14.dp),
                    painter = painterResource(id = R.drawable.arrow_back_icon),
                    contentDescription = "Назад",
                    tint = MeetsTheme.colors.neutralActive
                )
            }
        }
    ))

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