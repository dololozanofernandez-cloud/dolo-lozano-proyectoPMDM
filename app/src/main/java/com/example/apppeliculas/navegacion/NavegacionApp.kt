package com.example.apppeliculas.navegacion


import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.apppeliculas.ui.pantallas.PantallaCrearPelicula
import com.example.apppeliculas.ui.pantallas.PantallaListaPeliculas
import com.example.apppeliculas.ui.pantallas.PantallaLogin
import com.example.apppeliculas.ui.pantallas.PantallaRegistro
import kotlinx.serialization.Serializable



@Serializable
data object PantallaLoginKey : NavKey

@Serializable
data object PantallaRegistroKey : NavKey

@Serializable
data object PantallaListaPeliculasKey : NavKey

@Serializable
data class PantallaCrearPeliculaKey(val idPelicula: String = "") : NavKey

@Composable
fun NavegacionApp() {
    val backStack = rememberNavBackStack(
        PantallaLoginKey
    )
    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<PantallaLoginKey> {
                PantallaLogin(backStack)
            }
            entry<PantallaRegistroKey> {
                PantallaRegistro(backStack)
            }
            entry<PantallaListaPeliculasKey> {
                PantallaListaPeliculas(backStack)
            }
            entry<PantallaCrearPeliculaKey> {
                PantallaCrearPelicula(backStack, it.idPelicula)
            }

        }
    )

}