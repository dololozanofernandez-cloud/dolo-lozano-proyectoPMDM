package com.example.apppeliculas.ui.pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.acos

//.shadow(
//                    elevation = 1.dp,
//                    shape = RoundedCornerShape(20.dp),
//                    spotColor = Color(0xFF750707)
//                )

@Preview(showSystemUi = true)
@Composable
fun PantallaListaPeliculas(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF000000),
                        Color(0xFF750707)
                    ), radius = 800f
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                "Lista de películas",
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(9f)
                .padding(20.dp)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .border(3.dp, color = Color.Black, shape = RoundedCornerShape(20.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {},
                colors = ButtonColors(
                    containerColor = Color.Black,
                    Color.White,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.White
                ), modifier = Modifier.fillMaxWidth(0.89f), shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "Añadir",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif

                )

            }

        }
    }
}

fun crearPelicula() {

}