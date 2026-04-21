package com.example.apppeliculas.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.apppeliculas.model.Pelicula
import com.example.apppeliculas.ui.theme.primario

@Composable
fun lumCards(pelicula: Pelicula) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxHeight()
                    .background(Color.LightGray)
            ) {

                Text("🎬", modifier = Modifier.align(Alignment.Center))
            }

            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .padding(10.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${pelicula.titulo}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${pelicula.genero}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${pelicula.director}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

            }
            Box(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "❤  ${pelicula.puntuacion}",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    fontWeight = FontWeight.Bold
                )
            }


        }
    }
}