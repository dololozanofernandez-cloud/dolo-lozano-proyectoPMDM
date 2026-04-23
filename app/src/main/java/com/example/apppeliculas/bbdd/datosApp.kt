package com.example.apppeliculas.bbdd

import com.example.apppeliculas.modelo.Pelicula

object datosApp {
    var listaPeliculas = listOf(

        // Clásicos y Nouvelle Vague
        Pelicula(
            "Le Fabuleux Destin d'Amélie Poulain",
            "Comedia Romántica",
            "Jean-Pierre Jeunet",
            8.3
        ),
        Pelicula("Les Quatre Cents Coups", "Drama", "François Truffaut", 8.1),
        Pelicula("À bout de souffle", "Crimen/Drama", "Jean-Luc Godard", 7.7),
        Pelicula("Jules et Jim", "Drama/Romance", "François Truffaut", 7.7),
        Pelicula("Playtime", "Comedia", "Jacques Tati", 7.8),

        // Dramas e Historia
        Pelicula("Portrait de la jeune fille en feu", "Drama/Romance", "Céline Sciamma", 8.1),
        Pelicula("La Haine", "Crimen/Drama", "Mathieu Kassovitz", 8.1),
        Pelicula("Anatomie d'une chute", "Thriller/Drama", "Justine Triet", 7.7),
        Pelicula("The Artist", "Comedia/Drama", "Michel Hazanavicius", 7.9),
        Pelicula("Un prophète", "Crimen/Drama", "Jacques Audiard", 7.8),

        // Éxitos Populares y Comedia
        Pelicula("Intouchables", "Comedia/Drama", "Olivier Nakache", 8.5),
        Pelicula("Taxi", "Acción/Comedia", "Gérard Pirès", 7.0),
        Pelicula("Le dîner de cons", "Comedia", "Francis Veber", 7.6),
        Pelicula("Astérix & Obélix: Mission Cléopâtre", "Comedia", "Alain Chabat", 6.7),

        // Animación y Fantasía
        Pelicula("La Planète sauvage", "Animación/Ciencia Ficción", "René Laloux", 8.0),
        Pelicula("La Tortue Rouge", "Animación/Drama", "Michael Dudok de Wit", 7.5),
        Pelicula("Delicatessen", "Comedia/Fantasía", "Jean-Pierre Jeunet", 7.5),

        // Cine Contemporáneo
        Pelicula("Titane", "Terror/Drama", "Julia Ducournau", 6.6),
        Pelicula("Climax", "Terror/Drama", "Gaspar Noé", 6.9),
        Pelicula("Elle", "Thriller/Drama", "Paul Verhoeven", 7.1)
    )

}