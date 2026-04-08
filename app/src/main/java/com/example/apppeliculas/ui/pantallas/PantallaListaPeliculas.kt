package com.example.apppeliculas.ui.pantallas

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.acos

@Preview(showSystemUi = true)
@Composable
fun PantallaListaPeliculas(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFF750707)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Lista de películas",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 24.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(9f)
                .padding(15.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RectangleShape,
                    spotColor = Color(0xFF750707),
                    ambientColor = Color(0xFF750707)
                )
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .border(3.dp, color = Color.Black, shape = RectangleShape),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFF750707)),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {},
                colors = ButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.White
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    "Añadir",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 24.sp
                )
            }
        }
    }
}

fun crearPelicula() {

}