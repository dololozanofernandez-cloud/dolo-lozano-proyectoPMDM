package com.example.apppeliculas.ui.pantallas

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R
import com.example.apppeliculas.bbdd.remote.InstanciaRetrofit
import com.example.apppeliculas.modelo.Pelicula
import com.example.apppeliculas.ui.componentes.LumTextField
import com.example.apppeliculas.ui.componentes.LumToolBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaCrearPelicula(backStack: MutableList<NavKey>, idPelicula: String) {

    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("datos_app",Context.MODE_PRIVATE) }

    var titulo by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }
    var puntuacionStr by remember { mutableStateOf("") }
    val tokenGuardado = prefs.getString("token", "") ?: ""

    val esDetalle = idPelicula.isNotEmpty()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(idPelicula) {
        if (esDetalle) {
            try {

                val peliculaApi = withContext(Dispatchers.IO) {
                    InstanciaRetrofit.apiPeliculas.getById("Bearer $tokenGuardado", idPelicula)
                }

                titulo = peliculaApi.titulo
                genero = peliculaApi.genero
                director = peliculaApi.director
                puntuacionStr = peliculaApi.puntuacion.toString()
            } catch (e: Exception) {
                Toast.makeText(context, "Error al traer los detalles: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        }
    }

    val formularioValido = titulo.isNotEmpty() && genero.isNotEmpty() &&
            director.isNotEmpty() && puntuacionStr.isNotEmpty()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            LumToolBar(
                texto = if (esDetalle) "Detalle de película" else stringResource(R.string.añadir_pelicula_),
                backStack = backStack,
            )
        }

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                LumTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    vacio = titulo.isEmpty(),
                    etiqueta = stringResource(R.string.titulo),
                    textoErrorAbajo = stringResource(R.string.solicitar_titulo),
                    esContraseña = false
                )

                LumTextField(
                    value = genero,
                    onValueChange = {  genero = it },
                    vacio = genero.isEmpty(),
                    etiqueta = stringResource(R.string.genero),
                    textoErrorAbajo = stringResource(R.string.solicitar_genero),
                    esContraseña = false
                )

                LumTextField(
                    value = director,
                    onValueChange = {  director = it },
                    vacio = director.isEmpty(),
                    etiqueta = stringResource(R.string.director),
                    textoErrorAbajo = stringResource(R.string.solicitar_director),
                    esContraseña = false
                )

                LumTextField(
                    value = puntuacionStr,
                    onValueChange = {puntuacionStr = it },
                    vacio = puntuacionStr.isEmpty(),
                    etiqueta = stringResource(R.string.puntuacion),
                    textoErrorAbajo = stringResource(R.string.solicitar_puntuacion),
                    esContraseña = false
                )

                Spacer(modifier = Modifier.height(80.dp))

                Button(
                    onClick = {
                        if (formularioValido) {
                            val puntuacionDouble = puntuacionStr.toDoubleOrNull() ?: 0.0
                            val tokenGuardado = prefs.getString("token", "") ?: ""

                            val peliculaEditada = Pelicula(
                                id = if (idPelicula.isEmpty()) null else idPelicula,
                                titulo = titulo,
                                genero = genero,
                                director = director,
                                puntuacion = puntuacionDouble
                            )

                            coroutineScope.launch {
                                val resultadoExitoso = try {
                                    withContext(Dispatchers.IO) {

                                        if (esDetalle) {
                                            InstanciaRetrofit.apiPeliculas.actualizar(
                                                "Bearer $tokenGuardado",
                                                idPelicula,
                                                peliculaEditada
                                            )
                                        } else {
                                            InstanciaRetrofit.apiPeliculas.insertar(
                                                "Bearer $tokenGuardado",
                                                peliculaEditada
                                            )
                                        }
                                    }
                                    true
                                } catch (e: Exception) {
                                    Toast.makeText(context, "Error en el servidor: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                                    false
                                }

                                if (resultadoExitoso) {
                                    val mensaje = if (esDetalle) "¡Película modificada!" else "¡Película creada!"
                                    Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
                                    if (backStack.size > 1) {
                                        backStack.removeAt(backStack.size - 1)
                                    }
                                }
                            }
                        } else {
                            Toast.makeText(context, "Rellena todos los campos correctamente", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContainerColor = MaterialTheme.colorScheme.background,
                        disabledContentColor = MaterialTheme.colorScheme.onPrimary
                    ), modifier = Modifier.fillMaxWidth(0.8f), shape = CircleShape,
                    enabled = formularioValido
                ) {
                    Text(
                        text = if (esDetalle) "Modificar" else "Crear",
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                }
            }

        }
    }
}