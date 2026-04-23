package com.example.apppeliculas.ui.pantallas

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R
import com.example.apppeliculas.navegacion.PantallaListaPeliculasKey
import com.example.apppeliculas.navegacion.PantallaRegistroKey
import com.example.apppeliculas.ui.componentes.lumTextField
import com.example.apppeliculas.ui.theme.Fondo
import com.example.apppeliculas.ui.theme.primario
import androidx.core.content.edit


@Composable
fun PantallaLogin(backStack: NavBackStack<NavKey>) {

    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("datos_app", Context.MODE_PRIVATE) }

    val usuarioGuardado = prefs.getString("usuario", "") ?: ""
    var usuario by rememberSaveable() { mutableStateOf("") }
    var contraseña by rememberSaveable() {mutableStateOf("") }
    var contraseñaRep by rememberSaveable() {mutableStateOf("") }

    LaunchedEffect(Unit) {
        val usuarioGuardado = prefs.getString("usuario", "") ?: ""
        if (usuarioGuardado.isNotEmpty()) {
            usuario = usuarioGuardado
            prefs.edit { remove("usuario") }
        }}

val formularioValido = usuario.isNotEmpty() && contraseña.isNotEmpty() && contraseña==contraseñaRep
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(160.dp))
            Icon(
                painterResource(R.drawable.cintavideo),
                "LOGO",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(140.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "LUMIÈRE",
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color =  MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(25.dp))

            lumTextField(
                value = usuario,
                        onValueChange = {usuario = it},
                vacio = usuario.isEmpty(),
                etiqueta = "Usuario",
                textoErrorAbajo = "Debes introducir un usuario",
                icono  = {
                    Icon(
                        painterResource(R.drawable.usuario), "", tint =  MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = false
            )
            Spacer(modifier = Modifier.height(15.dp))

            lumTextField(
                value = contraseña,
                onValueChange = {contraseña= it},
                vacio = contraseña.isEmpty(),
                etiqueta = "Contraseña",
                textoErrorAbajo = "",
                icono = {
                    Icon(
                        painterResource(R.drawable.password), "", tint =  MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )
            Spacer(modifier = Modifier.height(15.dp))

            lumTextField(
                value = contraseñaRep,
                onValueChange = {contraseñaRep= it},
                vacio = contraseñaRep.isEmpty(),
                etiqueta = "Repita contraseña",
                textoErrorAbajo = "Contraseñas no iguales",
                icono = {
                    Icon(
                        painterResource(R.drawable.password),
                        "",
                        tint =  MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {backStack.clear()
                    backStack.add((PantallaListaPeliculasKey))},
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary
                ), modifier = Modifier.fillMaxWidth(0.7f), shape = CircleShape,
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
                "¿Nuevo en Lumière?",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Button(
                onClick = {backStack.add(PantallaRegistroKey)},
                contentPadding = PaddingValues(start = 8.dp),
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    "Regístrate aquí",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold

                )
            }
        }
    }

}


