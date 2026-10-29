package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sena.biblioteca.ui.navigation.AppScreens
import com.sena.biblioteca.ui.section.ReservationDetailActionsSection
import com.sena.biblioteca.ui.section.ReservationDetailHeaderSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationDetailScreen(
    navController: NavHostController,
    bookTitle: String,
    author: String,
    reservationDate: String,
    reservationCode: String,
    status: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalle de Reserva",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color(0xFF0D47A1)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Sección del encabezado, banner y tarjeta de detalles
            ReservationDetailHeaderSection(
                bookTitle = bookTitle,
                author = author,
                reservationDate = reservationDate,
                reservationCode = reservationCode,
                status = status
            )

            // Sección de los botones de acción inferiores (Renovar / Cancelar)
            ReservationDetailActionsSection(
                onRenewClick = {
                    navController.navigate(
                        AppScreens.RenewReservation(
                            bookTitle = bookTitle,
                            currentDate = reservationDate
                        )
                    )
                },
                onCancelClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}