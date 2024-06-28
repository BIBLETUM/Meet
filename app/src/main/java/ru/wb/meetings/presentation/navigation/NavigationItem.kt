package ru.wb.meetings.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import ru.wb.meetings.R

sealed class NavigationItem(
    val iconResId: Int,
    val titleOnSelectedResId: Int,
) {
    object Meets : NavigationItem(
        iconResId = R.drawable.cofee_icon,
        titleOnSelectedResId = R.string.navigation_item_meets
    )

    object Communities : NavigationItem(
        iconResId = R.drawable.people_icon,
        titleOnSelectedResId = R.string.navigation_item_communities
    )

    object More : NavigationItem(
        iconResId = R.drawable.three_dots_icon,
        titleOnSelectedResId = R.string.navigation_item_more
    )
}