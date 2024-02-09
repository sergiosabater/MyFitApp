@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.sergiosabater.myfit.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sergiosabater.myfit.ui.components.Calendar
import com.sergiosabater.myfit.utils.getCurrentMonthModel

@Composable
fun MainScreen(navController: NavHostController, paddingValues: PaddingValues) {
    // Usamos Box para permitir la superposición de elementos
    Box(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        // NavHost
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                CalendarContent(navController)
            }
            composable("event_input") {
                EventInputScreen()
            }
        }
    }
}

@Composable
fun CalendarContent(navController: NavHostController) {
    // Calendar composable dibujará el calendario
    Calendar(
        modifier = Modifier.fillMaxWidth(), // Esto hará que el calendario ocupe el ancho completo.
        model = getCurrentMonthModel()
    )
    Spacer(modifier = Modifier.height(16.dp))

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Botón flotante en la parte inferior de la pantalla
        FloatingActionButton(
            onClick = {
                // Al hacer clic en el botón, navegar a la pantalla de entrada del evento
                navController.navigate("event_input")
            },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .size(72.dp),
            shape = CircleShape,
            containerColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    // Crear un NavController falso para la vista previa
    val fakeNavController = rememberNavController()
    MainScreen(navController = fakeNavController, paddingValues = PaddingValues())
}

