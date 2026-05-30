package com.example.apppeliculas.bbdd.remote

import com.example.apppeliculas.modelo.Pelicula
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface PeliculasApiService {
    @GET("/api/v1/movies")
    suspend fun getAll(@Header("Authorization") token: String): List<Pelicula>

    @GET("/api/v1/movies/{id}")
    suspend fun getById(@Header("Authorization") token: String, @Path("id") id: String): Pelicula


    @POST("/api/v1/movies")
    suspend fun insertar(
        @Header("Authorization") token: String,
        @Body pelicula: Pelicula
    ): Pelicula


    @DELETE("/api/v1/movies/{id}")
    suspend fun deleteById(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): retrofit2.Response<Unit>
}