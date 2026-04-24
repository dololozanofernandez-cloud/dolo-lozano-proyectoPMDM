package com.example.apppeliculas.modelo

import kotlinx.serialization.Serializable

@Serializable
data class Pelicula (
    val titulo: String, val genero: String, val director: String,
    val puntuacion: String
){
}