package com.sena.biblioteca.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppScreens {

    @Serializable
    data object Home : AppScreens()

    @Serializable
    data object BookList : AppScreens()

    @Serializable
    data class BookDetail(
        val title: String,
        val author: String,
        val category: String,
        val description: String
    ) : AppScreens()

    @Serializable
    data object MyReservations : AppScreens()

    @Serializable
    data class ReservationConfirmation(
        val bookTitle: String,
        val reservationCode: String,
        val date: String
    ) : AppScreens()

    // --- NUEVAS RUTAS PARA EL FLUJO 2 ---

    @Serializable
    data class ReservationDetail(
        val bookTitle: String,
        val author: String,
        val reservationDate: String,
        val reservationCode: String,
        val status: String
    ) : AppScreens()

    @Serializable
    data class RenewReservation(
        val bookTitle: String,
        val currentDate: String
    ) : AppScreens()

    @Serializable
    data class RenewalSuccess(
        val bookTitle: String,
        val newDate: String
    ) : AppScreens()
}