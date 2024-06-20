package ru.wb.meetings.domain

import ru.wb.meetings.R

data class CommunityItem (
    val id: Int,
    val communityName: String = "Disigna",
    val communitySubscribersCount: Int = 10000,
    val communityImage: Int = R.drawable.community_image,
)