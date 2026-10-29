package com.sena.biblioteca.data

/**
 * Modelo de datos que representa una reserva activa del usuario.
 */
data class Reservation(
    val bookTitle: String,
    val author: String,
    val reservationDate: String,
    val reservationCode: String,
    val status: String // Ej: "Activa", "Renovada"
)