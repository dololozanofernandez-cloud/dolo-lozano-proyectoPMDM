package com.example.apppeliculas.ui.componentes

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R
import com.example.apppeliculas.bbdd.remote.InstanciaRetrofit
import com.example.apppeliculas.modelo.Pelicula
import com.example.apppeliculas.navegacion.PantallaCrearPeliculaKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun LumCards(
    pelicula: Pelicula,
    backStack: NavBackStack<NavKey>,
    onPeliculaEliminada: () -> Unit
) {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("datos_app", Context.MODE_PRIVATE) }
    val coroutineScope = rememberCoroutineScope()
    var mostrarDialogo by remember { mutableStateOf(false) }

    Card(
        onClick = { backStack.add(PantallaCrearPeliculaKey(idPelicula = pelicula.id ?: "")) },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                Text("🎬", modifier = Modifier.align(Alignment.Center))
            }

            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .padding(10.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = pelicula.titulo,
                    color = MaterialTheme.colorScheme.background,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = pelicula.genero,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = pelicula.director,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surface
                )
            }

            if (mostrarDialogo) {
                AlertDialog(
                    onDismissRequest = { mostrarDialogo = false },
                    title = { Text(text = stringResource(R.string.confirmar_eliminacion), color = MaterialTheme.colorScheme.primary) },
                    text = { Text(text = stringResource(R.string.confirmar_eliminacion2)) },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                val tokenGuardado = prefs.getString("token", "") ?: ""


                                coroutineScope.launch {
                                    try {
                                        withContext(Dispatchers.IO) {
                                            InstanciaRetrofit.apiPeliculas.deleteById("Bearer $tokenGuardado", pelicula.id ?: "")
                                        }
                                        Toast.makeText(context, "Película eliminada", Toast.LENGTH_SHORT).show()


                                        onPeliculaEliminada()
                                    } catch (e: Exception) {
                                        Toast.makeText(context, "Error al eliminar: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                                    } finally {
                                        mostrarDialogo = false
                                    }
                                }
                            }
                        ) {
                            Text(stringResource(R.string.eliminar), color = MaterialTheme.colorScheme.primary)
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { mostrarDialogo = false }) {
                            Text(stringResource(R.string.cancelar))
                        }
                    }
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "❤  ${pelicula.puntuacion}",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                IconButton(onClick = { mostrarDialogo = true }) {
                    Icon(
                        painterResource(R.drawable.outline_delete_24),
                        contentDescription = stringResource(R.string.eliminar_película),
                        tint = MaterialTheme.colorScheme.background
                    )
                }
            }
        }
    }
}