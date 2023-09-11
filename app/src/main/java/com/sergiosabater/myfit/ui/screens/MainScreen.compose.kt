package com.sergiosabater.myfit.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergiosabater.myfit.ui.components.Calendar

@Composable
fun MainScreen(onAddButtonClicked: () -> Unit) {

    // Usamos Box para permitir la superposición de elementos
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Calendar composable dibujará el calendario
        Calendar()

        // Botón flotante en la parte inferior de la pantalla
        FloatingActionButton(
            onClick = { onAddButtonClicked },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            shape = CircleShape
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