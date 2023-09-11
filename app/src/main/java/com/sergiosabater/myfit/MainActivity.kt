package com.sergiosabater.myfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sergiosabater.myfit.ui.screens.MainScreen
import com.sergiosabater.myfit.ui.theme.MyFitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(onAddButtonClicked = { /* Aquí irá el código para navegar a la
                     pantalla de registro */})
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MyFitTheme {
        MainScreen(onAddButtonClicked = {})
    }
}