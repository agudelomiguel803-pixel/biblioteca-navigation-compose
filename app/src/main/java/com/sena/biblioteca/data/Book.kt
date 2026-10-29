package com.sena.biblioteca.data

/**
 * Modelo de datos que representa un libro en el catálogo y sus detalles.
 */
data class Book(
    val title: String,
    val author: String,
    val category: String,
    val description: String,
    val defaultDate: String = "15/06/2026",
    val reservationCode: String = "RES-2026-001"
)
