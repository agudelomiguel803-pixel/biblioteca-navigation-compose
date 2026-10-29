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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sena.biblioteca.ui.navigation.AppScreens
import com.sena.biblioteca.ui.section.RenewReservationActionsSection
import com.sena.biblioteca.ui.section.RenewReservationContentSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenewReservationScreen(
    navController: NavHostController,
    bookTitle: String,
    currentDate: String
) {
    var newDate by remember { mutableStateOf("30/06/2026") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Renovar Reserva", fontWeight = FontWeight.Bold, color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = Color(0xFF0D47A1))
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
            // Sección del contenido y formulario de renovación
            RenewReservationContentSection(
                bookTitle = bookTitle,
                currentDate = currentDate,
                newDate = newDate,
                onNewDateChange = { newDate = it }
            )

            // Sección del botón inferior de confirmación
            RenewReservationActionsSection(
                onConfirmClick = {
                    navController.navigate(
                        AppScreens.RenewalSuccess(
                            bookTitle = bookTitle,
                            newDate = newDate
                        )
                    )
                }
            )
        }
    }
}