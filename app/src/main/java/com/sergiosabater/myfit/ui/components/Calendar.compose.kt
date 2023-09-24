package com.sergiosabater.myfit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergiosabater.myfit.model.CalendarModel
import com.sergiosabater.myfit.model.DayOfWeek
import com.sergiosabater.myfit.model.DaysOfMonth

@Composable
fun Calendar(
    modifier: Modifier = Modifier,
    model: CalendarModel
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .border(2.dp, Color.Blue, shape = RoundedCornerShape(24.dp)),
        verticalArrangement = Arrangement.Top
    ) {
        // Encabezado con el nombre del mes y el año
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${model.month} ${model.year}", // Se usa la información del modelo
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 24.dp)
            )
        }

        // Encabezado con los nombres de los días de la semana
        WeekDaysHeader()

        // Grid con los días del mes
        CalendarDaysGrid(model) // Pasar el día actual a la función
    }
}

@Composable
fun WeekDaysHeader() {
    val daysOfWeek = listOf("L", "M", "X", "J", "V", "S", "D")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        daysOfWeek.forEach { dayName ->
            Box(
                modifier = Modifier
                    .weight(1f, fill = false)
                    .aspectRatio(1f)
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
fun CalendarDaysGrid(model: CalendarModel) {  // Añadir el parámetro aquí
    val days = (1..model.totalDays.value).toList()
    val emptyDaysAtStart = model.startDayOfWeek.ordinal - 1
    val totalDaysWithEmptySpaces = emptyDaysAtStart + days.size
    val emptyDaysAtEnd =
        if (totalDaysWithEmptySpaces % 7 == 0) 0 else 7 - (totalDaysWithEmptySpaces % 7)
    val completeMonth = List(emptyDaysAtStart) { 0 } + days + List(emptyDaysAtEnd) { 0 }

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
                        DayCell(day, day in listOf(1, 5, 8, 15), day == model.currentDay)
                    }
                }
            }
        }
    }
}

@Composable
fun DayCell(day: Int, hasEvent: Boolean, isCurrentDay: Boolean = false) { // Añadir el nuevo parámetro
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
                        .size(40.dp)
                        .background(Color.Blue, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = day.toString(), color = Color.White)
                }
            } else if (isCurrentDay) {  // Verificar si es el día actual
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .border(2.dp, Color.Blue, CircleShape), // Bordo azul
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = day.toString(), color = Color.Black)
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
    // Creación de un objeto CalendarModel con la información deseada
    val sampleCalendarModel = CalendarModel(
        startDayOfWeek = DayOfWeek.Wednesday,
        totalDays = DaysOfMonth(31),
        month = "Septiembre",
        year = 2023,
        currentDay = 19  // Ejemplo: el día actual es el 19 de Septiembre
    )

    // Utilización del objeto CalendarModel en el composable Calendar
    Calendar(model = sampleCalendarModel)
}
