package com.sergiosabater.myfit.utils

import com.sergiosabater.myfit.model.CalendarModel
import com.sergiosabater.myfit.model.DayOfWeek
import com.sergiosabater.myfit.model.DaysOfMonth
import java.text.SimpleDateFormat
import java.util.*

fun getCurrentMonthModel(): CalendarModel {
    val calendar = Calendar.getInstance()
    //TODO: Prueba mes siguiente
    //calendar.add(Calendar.MONTH, 1) // Avanza al próximo mes
    calendar.set(Calendar.DAY_OF_MONTH, 1) // Ajustamos el calendario al primer día del mes

    val today = calendar.time
    val startDayOfWeek = DayOfWeek.of((calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7 + 1)
    val totalDays = DaysOfMonth(calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
    val month = SimpleDateFormat("MMMM", Locale.getDefault()).format(today)
    val year = calendar.get(Calendar.YEAR)
    val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

    return CalendarModel(startDayOfWeek, totalDays, month, year, currentDay)
}