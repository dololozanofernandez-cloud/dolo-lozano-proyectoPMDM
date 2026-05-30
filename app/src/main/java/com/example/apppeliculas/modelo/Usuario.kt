package com.example.apppeliculas.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Usuario(
    @Transient
    val id: String = "",
    @SerialName("email")
    val nombre: String,
    @SerialName("password")
    val pass: String=""
)