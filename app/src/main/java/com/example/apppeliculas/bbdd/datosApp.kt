package com.example.apppeliculas.bbdd

import com.example.apppeliculas.model.Pelicula

object datosApp {
    val listaPeliculas = listOf(
        // CIENCIA FICCIÓN & ACCIÓN
        Pelicula("Interstellar", "Ciencia Ficción", "Christopher Nolan", 8.7),
        Pelicula("The Matrix", "Acción", "Lana y Lilly Wachowski", 8.7),
        Pelicula("Blade Runner 2049", "Ciencia Ficción", "Denis Villeneuve", 8.0),
        Pelicula("Mad Max: Fury Road", "Acción", "George Miller", 8.1),

        // DRAMA & SUSPENSO
        Pelicula("The Godfather", "Drama", "Francis Ford Coppola", 9.2),
        Pelicula("Parasite", "Thriller", "Bong Joon-ho", 8.5),
        Pelicula("The Prestige", "Misterio", "Christopher Nolan", 8.5),
        Pelicula("Whiplash", "Drama", "Damien Chazelle", 8.5),

        // ANIMACIÓN
        Pelicula("Spirited Away", "Animación", "Hayao Miyazaki", 8.6),
        Pelicula("Coco", "Animación", "Lee Unkrich", 8.4),
        Pelicula("Spider-Man: Into the Spider-Verse", "Animación", "Peter Ramsey", 8.4),

        // TERROR
        Pelicula("The Shining", "Terror", "Stanley Kubrick", 8.4),
        Pelicula("Get Out", "Terror", "Jordan Peele", 7.8),
        Pelicula("Hereditary", "Terror", "Ari Aster", 7.3),

        // COMEDIA & OTROS
        Pelicula("The Grand Budapest Hotel", "Comedia", "Wes Anderson", 8.1),
        Pelicula("The Wolf of Wall Street", "Comedia", "Martin Scorsese", 8.2),
        Pelicula("La La Land", "Musical", "Damien Chazelle", 8.0),
        Pelicula("Everything Everywhere All At Once", "Aventura", "Daniel Kwan", 7.8),
        Pelicula("Cinema Paradiso", "Drama", "Giuseppe Tornatore", 8.5),
        Pelicula("Fight Club", "Drama", "David Fincher", 8.8)
    )
}