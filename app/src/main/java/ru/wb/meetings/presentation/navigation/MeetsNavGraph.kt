package ru.wb.meetings.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MeetsNavGraph(
    navHostController: NavHostController,
    profileScreenContent: @Composable () -> Unit,
    myMeetsScreenContent: @Composable () -> Unit,
    allMeetsScreenContent: @Composable () -> Unit,
    moreScreenContent: @Composable () -> Unit,
    communitiesScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Meets.route
    ) {
        composable(Screen.Profile.route) {
            profileScreenContent()
        }
        composable(Screen.MyMeets.route) {
            myMeetsScreenContent()
        }
        composable(Screen.Meets.route) {
            allMeetsScreenContent()
        }
        composable(Screen.More.route) {
            moreScreenContent()
        }
        composable(Screen.Communities.route) {
            communitiesScreenContent()
        }
    }
}