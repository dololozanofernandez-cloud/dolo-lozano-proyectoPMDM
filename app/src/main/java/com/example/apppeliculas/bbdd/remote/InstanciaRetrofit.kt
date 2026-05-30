package com.example.apppeliculas.bbdd.remote

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlin.getValue


object InstanciaRetrofit {
    private const val BASE_URL="https://moviesrestapi-production.up.railway.app"

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            json.asConverterFactory("application/json; charset=utf-8".toMediaType())
        ).build()
    }

    val apiPeliculas:PeliculasApiService by lazy {
        retrofit.create(PeliculasApiService::class.java)
    }

    val apiUsuario:UsuarioApiService by lazy{
        retrofit.create(UsuarioApiService::class.java)
    }
}