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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
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
import com.example.apppeliculas.navegacion.PantallaLoginKey
import com.example.apppeliculas.navegacion.PantallaRegistroKey
import com.example.apppeliculas.ui.componentes.lumTextField
import com.example.apppeliculas.ui.theme.Fondo
import com.example.apppeliculas.ui.theme.primario

@Composable
fun PantallaRegistro(backStack: NavBackStack<NavKey>) {

    val context = LocalContext.current
    val prefs = context.getSharedPreferences("datos_app", Context.MODE_PRIVATE)
    var usuario by rememberSaveable() { mutableStateOf("") }
    var email by rememberSaveable() { mutableStateOf("") }
    var contraseña by rememberSaveable() { mutableStateOf("") }
    var contraseñaRep by rememberSaveable() { mutableStateOf("") }

    var formularioValido = usuario.isNotEmpty() && email.isNotEmpty() && contraseña.isNotEmpty() && contraseña == contraseñaRep
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
            Text(
                text = "LUMIÈRE",
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = primario
            )
            Spacer(modifier = Modifier.height(25.dp))

            lumTextField(
                value = usuario,
                onValueChange = { usuario = it },
                vacio = true,
                etiqueta = "Nombre de usuario",
                textoErrorAbajo = "Debes introducir un usuario",
                icono = {
                    Icon(
                        painterResource(R.drawable.usuario), "", tint = primario,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = false
            )
            Spacer(modifier = Modifier.height(15.dp))

            lumTextField(
                value = email,
                onValueChange = { email = it },
                vacio = true,
                etiqueta = "Correo electrónico",
                textoErrorAbajo = "Debes introducir un correo",
                icono = {
                    Icon(
                        painterResource(R.drawable.email), "", tint = primario,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = false
            )
            Spacer(modifier = Modifier.height(15.dp))

            lumTextField(
                value = contraseña,
                onValueChange = { contraseña = it },
                vacio = true,
                etiqueta = "Contraseña",
                textoErrorAbajo = "Introduce una contraseña",
                icono = {
                    Icon(
                        painterResource(R.drawable.password), "", tint = primario,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )
            Spacer(modifier = Modifier.height(15.dp))

            lumTextField(
                value = contraseñaRep,
                onValueChange = { contraseñaRep = it },
                true,
                "Repita contraseña",
                "Contraseñas no iguales",
                {
                    Icon(
                        painterResource(R.drawable.password), "", tint = primario,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )
            Spacer(modifier = Modifier.height(45.dp))
            Button(
                onClick = {
                    prefs.edit().putString("usuario", usuario).apply()
                    if (backStack.size > 1) {
                        backStack.removeAt(backStack.size - 1)
                    }

                },
                colors = ButtonColors(
                    containerColor = primario,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.White
                ), modifier = Modifier.fillMaxWidth(0.7f), shape = CircleShape,
                enabled = formularioValido
            ) {
                Text(
                    "Regístrate",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif

                )

            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "¿Ya eres miembro?",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            Button(
                onClick = { backStack.add(PantallaLoginKey) },
                contentPadding = PaddingValues(start = 8.dp),
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = primario,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    "Inicio sesión",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold

                )
            }
        }
    }


}
