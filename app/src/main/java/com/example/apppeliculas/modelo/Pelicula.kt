package com.example.apppeliculas.modelo

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Pelicula(
    val id: String? = null,

    @SerialName("title")
    val titulo: String = "",

    @SerialName("genre")
    val genero: String = "",

    @SerialName("directorFullname")
    val director: String = "",

    @SerialName("rating")
    val puntuacion: Double
)