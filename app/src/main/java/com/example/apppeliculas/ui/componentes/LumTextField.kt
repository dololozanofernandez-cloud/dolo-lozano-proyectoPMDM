package com.example.apppeliculas.ui.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apppeliculas.R



@Composable
fun LumTextField(
    value: String,
    onValueChange: (String) -> Unit,
    vacio: Boolean = false,
    etiqueta: String,
    textoErrorAbajo: String,
    icono: @Composable (() -> Unit)? = null,
    esContraseña: Boolean
) {

    var seHaTocado by remember { mutableStateOf(false) }


    val tieneError = (vacio && seHaTocado && value.isEmpty()).apply {

        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
                seHaTocado = true
            },
            label = {
                Text(text = etiqueta, color = MaterialTheme.colorScheme.surface)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,

                errorContainerColor = MaterialTheme.colorScheme.onPrimary,
                errorIndicatorColor = MaterialTheme.colorScheme.primary,
                errorLabelColor = MaterialTheme.colorScheme.primary,
                focusedTextColor = MaterialTheme.colorScheme.background,
                unfocusedTextColor = MaterialTheme.colorScheme.background
            ),
            shape = CircleShape,
            isError = this,
            trailingIcon = {
                if (this) {
                    Icon(
                        painter = painterResource(R.drawable.outline_error_24),
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.primary
                    )
                } else if (esContraseña) {
                    Icon(
                        painter = painterResource(R.drawable.outline_visibility_off_24),
                        contentDescription = "Ver contraseña",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            supportingText = {
                if (this) {
                    Text(
                        text = textoErrorAbajo,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Start
                    )
                }
            },
            leadingIcon = icono,
            visualTransformation = if (esContraseña) {
                PasswordVisualTransformation('\u2022')
            } else {
                VisualTransformation.None
            }
        )
    }
}