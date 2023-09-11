package com.sergiosabater.myfit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Calendar() {
    // Obtenemos la fecha actual para determinar el mes y año actuales.
    val currentMonth = remember { mutableStateOf(java.util.Calendar.getInstance().get(java.util.Calendar.MONTH)) }
    val currentYear = remember { mutableStateOf(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)) }
    val events = remember { mutableStateOf(listOf(1, 5, 8, 15)) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        WeekDaysHeader()
        CalendarDaysGrid()
    }
}

@Composable
fun WeekDaysHeader() {
    val daysOfWeek = listOf("L", "M", "X", "J", "V", "S", "D")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        daysOfWeek.forEach { dayName ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .background(Color.Blue)
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = dayName,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun CalendarDaysGrid() {
    // Asumimos 30 días por simplicidad
    val days = (1..30).toList()
    val emptyDaysAtEnd = 7 - (days.size % 7)
    val completeMonth = days + List(emptyDaysAtEnd) { 0 }

    completeMonth.chunked(7).forEach { week ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            week.forEach { day ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .padding(4.dp)
                ) {
                    if (day != 0) {
                        DayCell(day, day in listOf(1, 5, 8, 15))
                    }
                }
            }
        }
    }
}

@Composable
fun DayCell(day: Int, hasEvent: Boolean) {
    if (day != 0) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            if (hasEvent) {
                Box(
                    modifier = Modifier
                        .size(40.dp) // Asegura que sea cuadrado
                        .background(Color.Blue, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = day.toString(), color = Color.White)
                }
            } else {
                Text(text = day.toString(), color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    Calendar()
}


