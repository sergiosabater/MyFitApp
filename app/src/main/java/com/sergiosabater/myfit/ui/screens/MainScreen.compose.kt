package com.sergiosabater.myfit.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergiosabater.myfit.model.DayOfWeek
import com.sergiosabater.myfit.model.DaysOfMonth
import com.sergiosabater.myfit.ui.components.Calendar

@Composable
fun MainScreen(onAddButtonClicked: () -> Unit) {

    // Usamos Box para permitir la superposición de elementos
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Calendar composable dibujará el calendario
        Calendar(
            modifier = Modifier.align(Alignment.TopCenter),
            startDayOfWeek = DayOfWeek.Friday,
            totalDays = DaysOfMonth(30),
            month = "Septiembre",
            year = 2023,
            currentDay = 20
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón flotante en la parte inferior de la pantalla
        FloatingActionButton(
            onClick = { onAddButtonClicked },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            shape = CircleShape,
            containerColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(onAddButtonClicked = {})
}