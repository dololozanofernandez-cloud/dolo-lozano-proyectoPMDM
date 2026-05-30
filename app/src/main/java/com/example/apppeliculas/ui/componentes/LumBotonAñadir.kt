package com.example.apppeliculas.ui.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R


@Composable
fun LumBotonAñadir(navKey: NavKey, backStack : NavBackStack<NavKey>) {

    Button(
        onClick = {backStack.add(navKey)},
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.background,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary
        ), shape = RoundedCornerShape(20.dp), modifier = Modifier
            .padding(16.dp)
            .size(80.dp)
    ) {
        Icon(painterResource(R.drawable.outline_add_24),
            stringResource(R.string.añadir), modifier = Modifier.size(28.dp))
    }

}
