package com.sena.biblioteca.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sena.biblioteca.ui.screen.BookDetailScreen
import com.sena.biblioteca.ui.screen.BookListScreen
import com.sena.biblioteca.ui.screen.HomeScreen
import com.sena.biblioteca.ui.screen.ReservationConfirmationScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.Home
    ) {
        // 1. Pantalla de Inicio
        composable<AppScreens.Home> {
            HomeScreen(navController = navController)
        }

        // 2. Pantalla de Lista de Libros
        composable<AppScreens.BookList> {
            BookListScreen(navController = navController)
        }

        // 3. Pantalla de Detalle del Libro
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

    }
}