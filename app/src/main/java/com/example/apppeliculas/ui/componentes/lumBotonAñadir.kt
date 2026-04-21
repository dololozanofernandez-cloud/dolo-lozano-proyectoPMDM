package com.example.apppeliculas.ui.componentes

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.apppeliculas.ui.theme.primario


@Composable
fun lumBotonAñadir() {

    Button(
        onClick = {},
        colors = ButtonColors(
            containerColor = primario,
            contentColor = Color.White,
            disabledContainerColor = Color.Black,
            disabledContentColor = Color.White
        ), shape = CircleShape
    ) {
        Text(
            "+",
            fontSize = 50.sp,
            fontFamily = FontFamily.SansSerif

        )
    }


}