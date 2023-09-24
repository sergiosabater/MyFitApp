package com.sergiosabater.myfit.model

data class CalendarModel(
    val startDayOfWeek: DayOfWeek,
    val totalDays: DaysOfMonth,
    val month: String,
    val year: Int,
    val currentDay: Int
)