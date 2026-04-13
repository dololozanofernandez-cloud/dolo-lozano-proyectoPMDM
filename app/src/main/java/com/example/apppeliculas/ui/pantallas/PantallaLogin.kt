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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apppeliculas.R
import com.example.apppeliculas.ui.lumTextField
import com.example.apppeliculas.ui.theme.Fondo
import com.example.apppeliculas.ui.theme.Superficie
import com.example.apppeliculas.ui.theme.primario

@Preview(showSystemUi = true)
@Composable
fun PantallaLogin() {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Fondo
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
                tint = primario,
                modifier = Modifier.size(140.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "LUMIÈRE",
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = primario
            )
            Spacer(modifier = Modifier.height(25.dp))
            lumTextField(
                true,
                "Usuario",
                "Debes introducir un usuario",
                {
                    Icon(
                        painterResource(R.drawable.usuario), "", tint = primario,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = false
            )
            Spacer(modifier = Modifier.height(15.dp))
            lumTextField(
                false,
                "Contraseña",
                "",
                {
                    Icon(
                        painterResource(R.drawable.password), "", tint = primario,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )
            Spacer(modifier = Modifier.height(15.dp))
            lumTextField(
                true,
                "Repita contraseña",
                "Contraseña errónea",
                {
                    Icon(
                        painterResource(R.drawable.password),
                        "",
                        tint = primario,
                        modifier = Modifier.size(32.dp)
                    )
                },
                esContraseña = true
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {},
                colors = ButtonColors(
                    containerColor = primario,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.White
                ), modifier = Modifier.fillMaxWidth(0.7f), shape = CircleShape
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
                color = Color.White
            )
            Button(
                onClick = {},
                contentPadding = PaddingValues(start = 8.dp),
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = primario,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.White
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
