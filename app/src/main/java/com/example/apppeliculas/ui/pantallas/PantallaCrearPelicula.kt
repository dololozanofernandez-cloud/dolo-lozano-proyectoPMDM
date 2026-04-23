package com.example.apppeliculas.ui.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R
import com.example.apppeliculas.bbdd.datosApp
import com.example.apppeliculas.navegacion.PantallaListaPeliculasKey
import com.example.apppeliculas.navegacion.PantallaLoginKey
import com.example.apppeliculas.ui.componentes.lumBotonAñadir
import com.example.apppeliculas.ui.componentes.lumTextField
import com.example.apppeliculas.ui.componentes.lumToolBar
import com.example.apppeliculas.ui.theme.Fondo
import com.example.apppeliculas.ui.theme.primario

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun PantalaCrearPelicula(backStack: NavBackStack<NavKey>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.backround
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
        ) {
            Text(
                text = "Añadir película",
                fontFamily = FontFamily.SansSerif,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        var titulo by rememberSaveable() { mutableStateOf("") }
        lumTextField(
            value = titulo,
            onValueChange = {titulo= it},
            vacio = true,
            etiqueta = "Título",
            textoErrorAbajo = "Debes introducir un título",
            esContraseña = false
        )
        Spacer(modifier = Modifier.height(15.dp))
        var genero by rememberSaveable() { mutableStateOf("") }
        lumTextField(
            value = genero,
            onValueChange = {genero= it},
            true,
            "Género",
            "Debes introducir un género",
            esContraseña = false
        )
        Spacer(modifier = Modifier.height(15.dp))
        var director by rememberSaveable() { mutableStateOf("") }
        lumTextField(
            value = director,
            onValueChange = {director= it},
            true,
            "Director",
            "Debes introducir un director",
            esContraseña = false
        )
        Spacer(modifier = Modifier.height(15.dp))
        var puntuacion by rememberSaveable() { mutableStateOf("") }
        lumTextField(
            value = puntuacion,
            onValueChange = {puntuacion= it},
            true,
            "Puntuación",
            "Debes introducir unha puntuación",
            esContraseña = false
        )
        Spacer(modifier = Modifier.height(45.dp))

        Button(
            onClick = {
                backStack.
            },
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = Color.Black,
                disabledContentColor = MaterialTheme.colorScheme.onPrimary,
            ), modifier = Modifier.fillMaxWidth(0.7f), shape = CircleShape
        ) {
            Text(
                "Añadir",
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif

            )

        }
    }
}
