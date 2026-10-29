package com.sena.biblioteca.ui.navigation

import kotlinx.serialization.Serializable

/**
 * Definición centralizada de las pantallas de la aplicación.
 */
sealed class AppScreens {

    // --- Flujo 1: Exploración y Reserva de Libros ---
    @Serializable
    object Home : AppScreens()

    @Serializable
    object BookList : AppScreens()

    @Serializable
    data class BookDetail(
        val title: String,
        val author: String,
        val category: String,
        val description: String
    ) : AppScreens()

    @Serializable
    data class ReservationConfirmation(
        val bookTitle: String,
        val reservationCode: String,
        val date: String
    ) : AppScreens()

    // --- Flujo 2: Gestión y Renovación de Reservas ---
    @Serializable
    object MyReservations : AppScreens()

    @Serializable
    data class ReservationDetail(
        val reservationCode: String,
        val bookTitle: String,
        val status: String
    ) : AppScreens()

    @Serializable
    data class RenewReservation(
        val reservationCode: String,
        val currentStatus: String
    ) : AppScreens()

    @Serializable
    data class RenewalSuccess(
        val reservationCode: String,
        val newStatus: String
    ) : AppScreens()
}