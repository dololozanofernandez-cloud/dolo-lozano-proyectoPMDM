package com.example.apppeliculas.ui.pantallas

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.navegacion.PantallaCrearPeliculaKey
import com.example.apppeliculas.ui.componentes.lumBotonAñadir
import com.example.apppeliculas.ui.componentes.lumContent
import com.example.apppeliculas.ui.componentes.lumToolBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun PantallaListaPeliculas(backStack : NavBackStack<NavKey>) {
    Scaffold(
        topBar = { lumToolBar("Lista películas") },
        content = { lumContent(backStack)},
        floatingActionButton = { lumBotonAñadir(PantallaCrearPeliculaKey(null), backStack) })

}





