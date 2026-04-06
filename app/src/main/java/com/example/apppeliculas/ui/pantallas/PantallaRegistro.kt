package com.example.apppeliculas.ui.pantallas

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apppeliculas.R
import com.example.apppeliculas.ui.crearTextField

@Preview(showSystemUi = true)
@Composable
fun PantallaRegistro() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF750707),
                        Color(0xFF000000)
                    ), radius = 2100f
                )
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
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(25.dp))
            crearTextField(
                true,
                "Nombre de usuario",
                "Debes introducir un usuario",
                {
                    Icon(
                        painterResource(R.drawable.usuario), "", tint = Color(0xFF750707),
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = false
            )
            Spacer(modifier = Modifier.height(15.dp))
            crearTextField(
                true,
                "Correo electrónico",
                "Debes introducir un correo",
                {
                    Icon(
                        painterResource(R.drawable.email), "", tint = Color(0xFF750707),
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = false
            )
            Spacer(modifier = Modifier.height(15.dp))
            crearTextField(
                true,
                "Contraseña",
                "Introduce una contraseña",
                {
                    Icon(
                        painterResource(R.drawable.password), "", tint = Color(0xFF750707),
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )
            Spacer(modifier = Modifier.height(15.dp))
            crearTextField(
                true,
                "Repita contraseña",
                "Contraseñas no iguales",
                {
                    Icon(
                        painterResource(R.drawable.password), "", tint = Color(0xFF750707),
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )
            Spacer(modifier = Modifier.height(45.dp))
            Button(
                onClick = {},
                colors = ButtonColors(
                    containerColor = Color.Black,
                    Color(0xFF750707),
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.White
                ), modifier = Modifier.fillMaxWidth(0.7f), shape = RectangleShape
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
                onClick = {},
                contentPadding = PaddingValues(start = 8.dp),
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFFC90A0A),
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