package com.example.apppeliculas.ui.componentes

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.apppeliculas.ui.theme.Fondo
import com.example.apppeliculas.ui.theme.primario

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun lumToolBar() {
    TopAppBar(
        title = {
            Text(
                "Lista de películas",
                fontFamily = FontFamily.SansSerif,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = primario
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Fondo
        )
    )
}