package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.sena.biblioteca.ui.section.BookDetailActionsSection
import com.sena.biblioteca.ui.section.BookDetailContentSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    navController: NavHostController,
    title: String,
    author: String,
    category: String,
    description: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalle del Libro",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF111111)
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
                .padding(20.dp)
        ) {
            // Sección de contenido principal del libro
            BookDetailContentSection(
                title = title,
                author = author,
                category = category,
                description = description,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Sección de acciones inferiores (Botón Reservar Libro)
            BookDetailActionsSection(
                onReserveClick = {
                    navController.navigate(
                        AppScreens.ReservationConfirmation(
                            bookTitle = title,
                            reservationCode = "RES-${(10000..99999).random()}",
                            date = "29/10/2026"
                        )
                    )
                }
            )
        }
    }
}