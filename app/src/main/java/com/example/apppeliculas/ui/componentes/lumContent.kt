package com.example.apppeliculas.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.bbdd.datosApp
import com.example.apppeliculas.ui.theme.Fondo

@Composable
fun lumContent(backStack : NavBackStack<NavKey>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Fondo)
    ) {
        items(datosApp.listaPeliculas) { pelicula ->
            lumCards(pelicula, backStack)
        }
    }
}