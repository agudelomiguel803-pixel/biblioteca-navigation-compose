package com.sena.biblioteca.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sena.biblioteca.ui.screen.BookDetailScreen
import com.sena.biblioteca.ui.screen.BookListScreen
import com.sena.biblioteca.ui.screen.HomeScreen
import com.sena.biblioteca.ui.screen.MyReservationsScreen
import com.sena.biblioteca.ui.screen.RenewReservationScreen
import com.sena.biblioteca.ui.screen.RenewalSuccessScreen
import com.sena.biblioteca.ui.screen.ReservationConfirmationScreen
import com.sena.biblioteca.ui.screen.ReservationDetailScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.Home
    ) {

        // --- FLUJO 1 ---

        composable<AppScreens.Home> {
            HomeScreen(navController = navController)
        }

        composable<AppScreens.BookList> {
            BookListScreen(navController = navController)
        }

        composable<AppScreens.BookDetail> { backStackEntry ->
            val bookDetailArgs = backStackEntry.toRoute<AppScreens.BookDetail>()

            BookDetailScreen(
                navController = navController,
                title = bookDetailArgs.title,
                author = bookDetailArgs.author,
                category = bookDetailArgs.category,
                description = bookDetailArgs.description
            )
        }

        composable<AppScreens.ReservationConfirmation> { backStackEntry ->
            val args = backStackEntry.toRoute<AppScreens.ReservationConfirmation>()

            ReservationConfirmationScreen(
                navController = navController,
                bookTitle = args.bookTitle,
                reservationCode = args.reservationCode,
                date = args.date
            )
        }

        // --- FLUJO 2 ---

        // 1. Pantalla de Mis Reservas
        composable<AppScreens.MyReservations> {
            MyReservationsScreen(navController = navController)
        }

        // 2. Pantalla de Detalle de Reserva
        composable<AppScreens.ReservationDetail> { backStackEntry ->
            val args = backStackEntry.toRoute<AppScreens.ReservationDetail>()
            ReservationDetailScreen(
                navController = navController,
                bookTitle = args.bookTitle,
                author = args.author,
                reservationDate = args.reservationDate,
                reservationCode = args.reservationCode,
                status = args.status
            )
        }

        // 3. Pantalla de Renovar Reserva
        composable<AppScreens.RenewReservation> { backStackEntry ->
            val args = backStackEntry.toRoute<AppScreens.RenewReservation>()
            RenewReservationScreen(
                navController = navController,
                bookTitle = args.bookTitle,
                currentDate = args.currentDate
            )
        }

        // 4. Pantalla de Renovación Exitosa
        composable<AppScreens.RenewalSuccess> { backStackEntry ->
            val args = backStackEntry.toRoute<AppScreens.RenewalSuccess>()
            RenewalSuccessScreen(
                navController = navController,
                bookTitle = args.bookTitle,
                newDate = args.newDate
            )
        }
    }
}