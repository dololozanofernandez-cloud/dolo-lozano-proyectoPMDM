package com.example.apppeliculas.ui.pantallas

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R
import com.example.apppeliculas.navegacion.PantallaListaPeliculasKey
import com.example.apppeliculas.navegacion.PantallaRegistroKey
import com.example.apppeliculas.ui.componentes.LumTextField
import androidx.core.content.edit
import com.example.apppeliculas.bbdd.remote.InstanciaRetrofit
import com.example.apppeliculas.modelo.Usuario
import kotlinx.coroutines.launch


@Composable
fun PantallaLogin(backStack: NavBackStack<NavKey>) {

    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("datos_app", Context.MODE_PRIVATE) }

    val usuarioGuardado = prefs.getString("usuario", "") ?: ""
    var usuario by rememberSaveable() { mutableStateOf("") }
    var contraseña by rememberSaveable() { mutableStateOf("") }
    var errorMensaje by rememberSaveable() { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        val usuarioGuardado = prefs.getString("usuario", "") ?: ""
        if (usuarioGuardado.isNotEmpty()) {
            usuario = usuarioGuardado
            prefs.edit { val remove = remove("usuario") }
        }
    }


    val formularioValido = usuario.isNotEmpty() && contraseña.isNotEmpty()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Icon(
                painterResource(R.drawable.cintavideo),
                stringResource(R.string.logo),
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(140.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "LUMIÈRE",
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(25.dp))

            LumTextField(
                value = usuario,
                onValueChange = { usuario = it },
                vacio = usuario.isEmpty(),
                etiqueta = stringResource(R.string.usuario),
                textoErrorAbajo = "Debes introducir un usuario",
                icono = {
                    Icon(
                        painterResource(R.drawable.usuario),
                        "",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = false
            )
            Spacer(modifier = Modifier.height(15.dp))

            LumTextField(
                value = contraseña,
                onValueChange = { contraseña = it },
                vacio = contraseña.isEmpty(),
                etiqueta = stringResource(R.string.contraseña),
                textoErrorAbajo = "",
                icono = {
                    Icon(
                        painterResource(R.drawable.password),
                        "",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )

            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {

                        val usuarioDelFormulario = Usuario("", usuario.trim(), contraseña.trim())
                        coroutineScope.launch {
                            try {
                            val respuesta = InstanciaRetrofit.apiUsuario.login(usuarioDelFormulario)
                            val token = respuesta["token"]
                            prefs.edit {
                                putString("token", token).apply()
                            }
                                backStack.clear()
                                backStack.add((PantallaListaPeliculasKey))
                            } catch (e: retrofit2.HttpException) {
                                Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                            } catch (e: Exception) {
                                Toast.makeText(context, "Error de conexión", Toast.LENGTH_SHORT).show()
                            }
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
                    "Entrar",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif

                )

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.nuevo_lumière),
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Button(
                onClick = { backStack.add(PantallaRegistroKey) },
                contentPadding = PaddingValues(start = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.background,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    stringResource(R.string.registrate),
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold

                )
            }
        }
    }

}


