package com.example.apppeliculas.ui.componentes

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope // IMPORTANTE añadir
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.bbdd.remote.InstanciaRetrofit
import com.example.apppeliculas.modelo.Pelicula
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch // IMPORTANTE añadir
import kotlinx.coroutines.withContext

@Composable
fun LumContent(backStack : NavBackStack<NavKey>) {

    var listaPeliculas: List<Pelicula> by remember { mutableStateOf(listOf<Pelicula>()) }

    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("datos_app", Context.MODE_PRIVATE) }
    val tokenGuardado = prefs.getString("token", "") ?: ""


    val coroutineScope = rememberCoroutineScope()

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                coroutineScope.launch {
                    try {

                        val tokenFresco = prefs.getString("token", "") ?: ""

                        val resultado = withContext(Dispatchers.IO) {
                            InstanciaRetrofit.apiPeliculas.getAll("Bearer $tokenFresco")
                        }
                        listaPeliculas = resultado
                    } catch (e: Exception) {
                        Toast.makeText(
                            context,
                            "Error al refrescar: ${e.localizedMessage}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {

        items(listaPeliculas) { pelicula ->
            LumCards(
                pelicula = pelicula,
                backStack = backStack,
                onPeliculaEliminada = {

                    coroutineScope.launch {
                        try {
                            val tokenFresco = prefs.getString("token", "") ?: ""
                            val listaActualizada = withContext(Dispatchers.IO) {
                                InstanciaRetrofit.apiPeliculas.getAll("Bearer $tokenFresco")
                            }

                            listaPeliculas = listaActualizada
                        } catch (e: Exception) {
                            Toast.makeText(context, "Error al refrescar: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            )
        }
    }
}