@file:OptIn(ExperimentalMaterial3Api::class)

package com.sergiosabater.myfit.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergiosabater.myfit.ui.components.CustomTopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalMaterial3Api
@Composable
fun EventInputScreen() {
    Scaffold(topBar = {
        CustomTopAppBar(title = "Añadir Evento", onNavIconClick = { /*TODO: Navegar hacia atrás*/ })
    }) { paddingValues ->  // Usamos el PaddingValues proporcionado por el Scaffold
        // Hacer la columna desplazable
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(paddingValues), // Aplicamos el padding aquí
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "1 de enero de 2024", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            val exerciseList = listOf("Flexiones", "Dominadas", "Barra", "Bicicleta")
            var exercise by remember { mutableStateOf(exerciseList[0]) }
            var expanded by remember { mutableStateOf(false) }

            // Dropdown para seleccionar el ejercicio
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = exercise,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = !expanded }
                        .padding(16.dp))
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    exerciseList.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) }, // Pasar el texto como un parámetro
                            onClick = {
                                exercise = item
                                expanded = false
                            }
                        )
                    }
                }
            }

            when (exercise) {
                "Flexiones", "Dominadas", "Barra" -> {
                    var series by remember { mutableStateOf(1) }
                    var repetitions by remember { mutableStateOf(1) }

                    NumberSpinner(value = series, onValueChange = { series = it }, range = 1..10)
                    Spacer(modifier = Modifier.height(8.dp))
                    NumberSpinner(
                        value = repetitions, onValueChange = { repetitions = it }, range = 1..50
                    )
                }

                "Bicicleta" -> {
                    var minutes by remember { mutableStateOf(1) }
                    NumberSpinner(value = minutes, onValueChange = { minutes = it }, range = 1..120)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*TODO: Guardar información*/ },
                colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)
            ) {
                Text(text = "Guardar", color = Color.White)
            }
        }
    }
}

@Composable
fun NumberSpinner(
    value: Int, onValueChange: (Int) -> Unit, range: IntRange
) {
    Row(
        modifier = Modifier
            .border(1.dp, Color.Gray)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            if (value > range.first) {
                onValueChange(value - 1)
            }
        }) {
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Incrementar")
        }

        Text(
            text = value.toString(), modifier = Modifier.padding(horizontal = 16.dp)
        )

        IconButton(onClick = {
            if (value < range.last) {
                onValueChange(value + 1)
            }
        }) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Decrementar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventInputScreenPreview() {
    EventInputScreen()
}
