package com.example.apppeliculas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.apppeliculas.navegacion.NavegacionApp
import com.example.apppeliculas.ui.theme.AppPeliculasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppPeliculasTheme {
                NavegacionApp()
            }
        }
    }
}

