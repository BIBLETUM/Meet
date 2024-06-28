package ru.wb.meetings.presentation.navigation

import ru.wb.meetings.R

sealed class NavigationItem(
    val screen: Screen,
    val iconResId: Int,
    val titleOnSelectedResId: Int,
) {
    object Meets : NavigationItem(
        screen = Screen.Meets,
        iconResId = R.drawable.cofee_icon,
        titleOnSelectedResId = R.string.navigation_item_meets
    )

    object Communities : NavigationItem(
        screen = Screen.Communities,
        iconResId = R.drawable.people_icon,
        titleOnSelectedResId = R.string.navigation_item_communities
    )

    object More : NavigationItem(
        screen = Screen.More,
        iconResId = R.drawable.three_dots_icon,
        titleOnSelectedResId = R.string.navigation_item_more
    )
}