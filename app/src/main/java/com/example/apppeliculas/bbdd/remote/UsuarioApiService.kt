package com.example.apppeliculas.bbdd.remote

import android.R
import com.example.apppeliculas.modelo.Usuario
import kotlinx.serialization.descriptors.StructureKind
import retrofit2.http.Body
import retrofit2.http.POST

interface UsuarioApiService {
    @POST("/api/v1/users/login")
    suspend fun login(@Body u: Usuario): Map<String, String>
    @POST("/api/v1/users/signup")
    suspend fun registro(@Body u: Usuario): Usuario
}