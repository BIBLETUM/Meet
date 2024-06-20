package ru.wb.meetings.domain

import ru.wb.meetings.R

data class EventItem (
    val id: Int = 0,
    val meetingName: String = "Developer meeting",
    val date: String = "13.09.2024",
    val city: String = "Москва",
    val meetingImage: Int = R.drawable.meeting_image_placeholder,
    val status: String = "Закончилась",
    val tags: List<String> = listOf("Python", "Junior", "Moscow")
)