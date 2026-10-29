package com.sena.biblioteca.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/**
 * Grafo de navegación principal que mapea cada ruta con su respectiva pantalla.
 */
@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.Home
    ) {
        // --- Flujo 1: Exploración y Reserva de Libros ---
        composable<AppScreens.Home> {
        }

        composable<AppScreens.BookList> {
        }

        composable<AppScreens.BookDetail> { backStackEntry ->
        }

        composable<AppScreens.ReservationConfirmation> { backStackEntry ->
        }

        // --- Flujo 2: Gestión y Renovación de Reservas ---
        composable<AppScreens.MyReservations> {
        }

        composable<AppScreens.ReservationDetail> { backStackEntry ->
        }

        composable<AppScreens.RenewReservation> { backStackEntry ->
        }

        composable<AppScreens.RenewalSuccess> { backStackEntry ->
        }
    }
}