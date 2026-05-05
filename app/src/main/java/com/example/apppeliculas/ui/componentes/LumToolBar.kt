package com.example.apppeliculas.ui.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LumToolBar(texto: String,backStack: MutableList<NavKey>) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                texto,
                fontFamily = FontFamily.SansSerif,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        },
        navigationIcon = {
            IconButton(onClick ={if (backStack.size > 1) backStack.removeAt(backStack.size - 1)}) {
                Icon(
                    painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = "Atrás"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}