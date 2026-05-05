package com.example.apppeliculas.ui.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R
import com.example.apppeliculas.navegacion.PantallaCrearPeliculaKey
import com.example.apppeliculas.ui.componentes.LumBotonAñadir
import com.example.apppeliculas.ui.componentes.LumContent
import com.example.apppeliculas.ui.componentes.LumToolBar


@Composable
fun PantallaListaPeliculas(backStack: NavBackStack<NavKey>) {
    Scaffold(
        topBar = {
            LumToolBar(
                texto = stringResource(R.string.lista_peliculas),backStack,

            )
        },
        content = { paddingValues ->

            Box(modifier = Modifier.padding(paddingValues)) {
                LumContent(backStack)
            }
        },
        floatingActionButton = {
            LumBotonAñadir(PantallaCrearPeliculaKey(null), backStack)
        }
    )
}





