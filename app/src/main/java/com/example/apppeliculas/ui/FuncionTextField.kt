package com.example.apppeliculas.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apppeliculas.R

@Composable
fun crearTextField(
    vacio: Boolean = false,
    etiqueta: String,
    textoErrorAbajo: String,
    icono: @Composable (() -> Unit)? = null,
    esContraseña: Boolean
) {
    var texto by rememberSaveable { mutableStateOf("") }
    var textoError = false
    if (vacio) {
        textoError = texto.isEmpty()
    }
        TextField(
            value = texto,
            onValueChange = { texto = it },
            label = {
                Text(etiqueta, color = Color.Gray)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color(0xFF750707),
                focusedIndicatorColor = Color(0xFF750707),

                errorContainerColor = Color.White,
                errorIndicatorColor = Color.Black,
                errorLabelColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black



            ),
            shape = RectangleShape,
            isError = textoError,
            trailingIcon = {
                if (textoError) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Error",
                        tint = Color(0xFF750707)
                    )
                }else if (esContraseña) {
                    Icon(painterResource(R.drawable.outline_visibility_off_24),"" , tint = Color(0xFF750707))
                }
            },
            supportingText = {
                if (textoError) {
                    Text(
                        text = textoErrorAbajo,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Start
                    )
                }
            },
            leadingIcon = icono,
            visualTransformation =
                if (esContraseña) {
                    PasswordVisualTransformation('\u2022')
                } else {
                    VisualTransformation.None

                }

        )
    }
