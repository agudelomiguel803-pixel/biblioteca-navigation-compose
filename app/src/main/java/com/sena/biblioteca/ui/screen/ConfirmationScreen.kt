package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sena.biblioteca.ui.navigation.AppScreens
import com.sena.biblioteca.ui.section.ConfirmationActionsSection
import com.sena.biblioteca.ui.section.ConfirmationHeaderSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationConfirmationScreen(
    navController: NavHostController,
    bookTitle: String,
    reservationCode: String = "RES-84920",
    date: String = "29/10/2026"
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Reserva Confirmada",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF111111)
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Sección del encabezado y comprobante
            ConfirmationHeaderSection(
                bookTitle = bookTitle,
                reservationCode = reservationCode,
                date = date
            )

            // Sección de acciones inferiores (Botón Volver al Inicio)
            ConfirmationActionsSection(
                onHomeClick = {
                    navController.navigate(AppScreens.Home) {
                        popUpTo(AppScreens.Home) { inclusive = true }
                    }
                }
            )
        }
    }
}