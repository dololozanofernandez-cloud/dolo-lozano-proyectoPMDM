package com.example.apppeliculas.ui.componentes

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.navegacion.PantallaCrearPeliculaKey
import com.example.apppeliculas.ui.theme.primario


@Composable
fun lumBotonAñadir(navKey: NavKey, backStack : NavBackStack<NavKey>) {

    Button(
        onClick = {backStack.add(navKey)},
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = Color.Black,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary
        ), shape = CircleShape
    ) {
        Text(
            "+",
            fontSize = 50.sp,
            fontFamily = FontFamily.SansSerif

        )
    }


}
