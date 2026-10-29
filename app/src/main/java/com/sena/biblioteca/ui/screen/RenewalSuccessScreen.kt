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
import com.sena.biblioteca.ui.section.RenewalSuccessActionsSection
import com.sena.biblioteca.ui.section.RenewalSuccessHeaderSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenewalSuccessScreen(
    navController: NavHostController,
    bookTitle: String,
    newDate: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Renovación Exitosa", fontWeight = FontWeight.Bold, color = Color.Black) }
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
            // Sección del encabezado y tarjeta de detalles
            RenewalSuccessHeaderSection(
                bookTitle = bookTitle,
                newDate = newDate
            )

            // Sección de acciones inferiores (Botón de retorno)
            RenewalSuccessActionsSection(
                onBackToReservationsClick = {
                    navController.navigate(AppScreens.MyReservations) {
                        popUpTo(AppScreens.MyReservations) { inclusive = true }
                    }
                }
            )
        }
    }
}