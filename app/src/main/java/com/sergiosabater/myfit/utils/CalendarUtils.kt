package com.sergiosabater.myfit.utils

import com.sergiosabater.myfit.model.CalendarModel
import com.sergiosabater.myfit.model.DayOfWeek
import com.sergiosabater.myfit.model.DaysOfMonth
import java.text.SimpleDateFormat
import java.util.*

fun getCurrentMonthModel(): CalendarModel {
    val calendar = Calendar.getInstance()

    // Obtenemos el día actual
    val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

    // Ajustamos el calendario al primer día del mes
    //calendar.add(Calendar.MONTH, 1) // Avanza al próximo mes
    calendar.set(Calendar.DAY_OF_MONTH, 1)

    val today = calendar.time
    val startDayOfWeek = DayOfWeek.of((calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7 + 1)
    val totalDays = DaysOfMonth(calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
    val month = SimpleDateFormat("MMMM", Locale.getDefault()).format(today)
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    val year = calendar.get(Calendar.YEAR)

    return CalendarModel(startDayOfWeek, totalDays, month, year, currentDay)
}