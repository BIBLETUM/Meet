package ru.wb.meetings.presentation.navigation

sealed class Screen(
    val route: String,
) {
    object Profile : Screen(ROUTE_PROFILE)
    object MyMeets : Screen(ROUTE_MY_MEETS)
    object AllMeets : Screen(ROUTE_ALL_MEETS)
    object More : Screen(ROUTE_MORE)

    private companion object {
        const val ROUTE_PROFILE = "Profile_screen_route"
        const val ROUTE_MY_MEETS = "My_meets_screen_route"
        const val ROUTE_ALL_MEETS = "All_meets_screen_route"
        const val ROUTE_MORE = "More_screen_route"
    }

}