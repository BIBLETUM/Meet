package ru.wb.meetings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.R
import ru.wb.meetings.presentation.navigation.MeetsNavGraph
import ru.wb.meetings.presentation.navigation.NavigationItem
import ru.wb.meetings.presentation.navigation.Screen
import ru.wb.meetings.presentation.screen.AllMeetsScreen
import ru.wb.meetings.presentation.screen.CommunitiesScreen
import ru.wb.meetings.presentation.screen.MoreScreen
import ru.wb.meetings.presentation.screen.MyMeetsScreen
import ru.wb.meetings.presentation.screen.ProfileScreen
import ru.wb.meetings.presentation.theme.MeetsTheme

@Preview
@Composable
fun MeetsMainScreen() {
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val navHostController = rememberNavController()
    var appBarState by remember {
        mutableStateOf(AppBarState())
    }
    Scaffold(
        modifier = Modifier.background(color = MeetsTheme.colors.neutralWhite),
        topBar = { MeetsTopAppBar(appBarState = appBarState) },
        bottomBar = {
            BottomNavigationBar {
                val navigationItems = listOf(
                    NavigationItem.Meets,
                    NavigationItem.Communities,
                    NavigationItem.More
                )
                navigationItems.forEachIndexed { index, navigationItem ->
                    BottomNavigationBarItem(
                        labelResId = navigationItem.titleOnSelectedResId,
                        selected = selectedItemIndex == index,
                        iconResId = navigationItem.iconResId,
                        index = index
                    ) {
                        selectedItemIndex = index
                        navHostController.navigate(navigationItem.screen.route) {
                            popUpTo(Screen.Meets.route)
                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        MeetsNavGraph(
            navHostController = navHostController,
            profileScreenContent = {
                ProfileScreen(
                    paddingValues = paddingValues,
                    onComposing = {
                        appBarState = it
                    },
                    navigateBack = { navHostController.popBackStack() },
                    navigateToEditProfile = {})
            },
            myMeetsScreenContent = {
                MyMeetsScreen(
                    paddingValues = paddingValues,
                    onComposing = {
                        appBarState = it
                    },
                    navigateBack = { navHostController.popBackStack() }
                )
            },
            allMeetsScreenContent = {
                AllMeetsScreen(
                    paddingValues = paddingValues,
                    onComposing = {
                        appBarState = it
                    },
                    navigateToAddMeet = {}
                )
            },
            moreScreenContent = {
                MoreScreen(
                    paddingValues = paddingValues,
                    onComposing = {
                        appBarState = it
                    },
                    navigateToMyMeets = {
                        navHostController.navigate(Screen.MyMeets.route)
                    },
                    navigateToProfile = {
                        navHostController.navigate(Screen.Profile.route)
                    }
                )
            },
            communitiesScreenContent = {
                CommunitiesScreen(
                    onComposing = {
                        appBarState = it
                    },
                )
            })
    }
}

data class AppBarState(
    val title: String = "",
    val navigationIcon: (@Composable RowScope.() -> Unit)? = null,
    val actions: (@Composable RowScope.() -> Unit)? = null
)

@Composable
private fun MeetsTopAppBar(
    modifier: Modifier = Modifier,
    appBarState: AppBarState,
) {
    Box(
        modifier = modifier
            .background(MeetsTheme.colors.neutralWhite)
            .fillMaxWidth()
    ) {
        val horizontalPadding = if (appBarState.navigationIcon == null) 24.dp else 16.dp
        Row(
            modifier = modifier
                .padding(vertical = 14.dp, horizontal = horizontalPadding)
                .fillMaxWidth()
                .height(30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            appBarState.navigationIcon?.invoke(this)
            Text(
                modifier = modifier.weight(1f),
                text = appBarState.title,
                style = MeetsTheme.typography.subheading1,
                color = MeetsTheme.colors.neutralActive
            )
            appBarState.actions?.invoke(this)
        }
    }

}

@Composable
private fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
            .shadow(20.dp)
            .fillMaxWidth()
            .height(64.dp)
            .background(MeetsTheme.colors.neutralWhite),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp, bottom = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

@Composable
private fun RowScope.BottomNavigationBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean = true,
    labelResId: Int = R.string.navigation_item_meets,
    iconResId: Int = R.drawable.cofee_icon,
    index: Int = 0,
    onClick: () -> Unit = {},
) {
    val contentAlignment: Alignment = when (index) {
        0 -> Alignment.CenterStart
        1 -> Alignment.Center
        2 -> Alignment.CenterEnd
        else -> Alignment.Center
    }
    Box(
        modifier = modifier
            .height(44.dp)
            .weight(1f),
        contentAlignment = contentAlignment,
    ) {
        Box(modifier = Modifier.clickable(enabled = true) {
            onClick()
        }) {


            if (selected) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 13.dp, vertical = 6.dp)
                        .height(58.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = labelResId),
                        color = MeetsTheme.colors.neutralActive,
                        style = MeetsTheme.typography.subheading2
                    )
                    Icon(
                        modifier = Modifier
                            .size(4.dp),
                        painter = painterResource(
                            id = R.drawable.dot_icon
                        ), contentDescription = stringResource(id = labelResId)
                    )
                }
            } else {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 13.dp, vertical = 6.dp)
                        .size(32.dp),
                    painter = painterResource(id = iconResId),
                    contentDescription = stringResource(id = labelResId)
                )
            }
        }
    }
}
