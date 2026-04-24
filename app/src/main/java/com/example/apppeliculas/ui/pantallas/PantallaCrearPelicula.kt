package com.example.apppeliculas.ui.pantallas

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.bbdd.datosApp
import com.example.apppeliculas.modelo.Pelicula
import com.example.apppeliculas.navegacion.PantallaListaPeliculasKey
import com.example.apppeliculas.ui.componentes.lumTextField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun PantalaCrearPelicula(backStack: NavBackStack<NavKey>, pelicula: Pelicula?) {
    val context = LocalContext.current

    var titulo by rememberSaveable(pelicula) { mutableStateOf(pelicula?.titulo ?:  "") }
    var genero by rememberSaveable(pelicula) { mutableStateOf(pelicula?.genero ?:  "") }
    var director by rememberSaveable(pelicula) { mutableStateOf(pelicula?.director ?:  "") }
    var puntuacion by rememberSaveable(pelicula) { mutableStateOf(pelicula?.puntuacion ?:  "") }

    var formularioValido = titulo.isNotEmpty() && genero.isNotEmpty() && director.isNotEmpty() && puntuacion.isNotEmpty()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
        ) {
            Text(
                text = if(pelicula == null){
                    "Añadir película"
                } else {
                    "Editar película"
                },
                fontFamily = FontFamily.SansSerif,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        lumTextField(
            value = titulo,
            onValueChange = {titulo= it},
            vacio = titulo.isEmpty(),
            etiqueta = "Título",
            textoErrorAbajo = "Debes introducir un título",
            esContraseña = false
        )
        Spacer(modifier = Modifier.height(15.dp))
        lumTextField(
            value = genero,
            onValueChange = {genero= it},
            genero.isEmpty(),
            "Género",
            "Debes introducir un género",
            esContraseña = false
        )
        Spacer(modifier = Modifier.height(15.dp))
        lumTextField(
            value = director,
            onValueChange = {director= it},
            director.isEmpty(),
            "Director",
            "Debes introducir un director",
            esContraseña = false
        )
        Spacer(modifier = Modifier.height(15.dp))
        lumTextField(
            value = puntuacion,
            onValueChange = {puntuacion= it},
            puntuacion.isEmpty(),
            "Puntuación",
            "Debes introducir unha puntuación",
            esContraseña = false
        )
        Spacer(modifier = Modifier.height(45.dp))

        Button(
            onClick = {
                val nuevaPelicula = Pelicula(titulo, genero, director, puntuacion)

                val indiceExistente = datosApp.listaPeliculas.indexOfFirst { it.titulo == nuevaPelicula.titulo }

                if (indiceExistente != -1) {
                    datosApp.listaPeliculas[indiceExistente] = nuevaPelicula
                } else {
                    datosApp.listaPeliculas.add(nuevaPelicula)
                }
                Toast.makeText(context, "¡Película guardada!", Toast.LENGTH_SHORT).show()

                titulo = ""
                genero = ""
                director = ""
                puntuacion = ""

                if(backStack.size > 1){
                    backStack.removeAt(backStack.size-1)
                }

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = Color.Black,
                disabledContentColor = MaterialTheme.colorScheme.onPrimary
            ), modifier = Modifier.fillMaxWidth(0.7f), shape = CircleShape,
            enabled = formularioValido
        ) {
            Text(
                "Añadir",
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif

            )

        }
    }
}
