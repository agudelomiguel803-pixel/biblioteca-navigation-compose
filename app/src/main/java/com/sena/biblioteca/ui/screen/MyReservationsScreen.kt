package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sena.biblioteca.ui.navigation.AppScreens
import com.sena.biblioteca.ui.section.ReservationListSection

data class ReservationItem(
    val bookTitle: String,
    val author: String,
    val date: String,
    val code: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyReservationsScreen(
    navController: NavHostController
) {
    // Tus 5 libros exactos de la interfaz
    val reservationsList = listOf(
        ReservationItem(
            bookTitle = "Harry Potter y la piedra filosofal",
            author = "J.K. Rowling",
            date = "29/10/2026",
            code = "RES-2026-001",
            status = "Activa"
        ),
        ReservationItem(
            bookTitle = "Alicia en el pais de las maravillas",
            author = "Lewis Carroll",
            date = "30/10/2026",
            code = "RES-2026-002",
            status = "Activa"
        ),
        ReservationItem(
            bookTitle = "Las Crónicas de Narnia",
            author = "C.S. Lewis",
            date = "02/11/2026",
            code = "RES-2026-003",
            status = "Activa"
        ),
        ReservationItem(
            bookTitle = "Peter Pan",
            author = "J.M. Barrie",
            date = "05/11/2026",
            code = "RES-2026-004",
            status = "Activa"
        ),
        ReservationItem(
            bookTitle = "Coraline",
            author = "Neil Gaiman",
            date = "10/11/2026",
            code = "RES-2026-005",
            status = "Activa"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mis Reservas",
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = null,
                    tint = Color(0xFF0D47A1),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Lista de reservas activas",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sección modularizada con la lista de reservas
            ReservationListSection(
                reservations = reservationsList,
                onViewDetail = { reservation ->
                    navController.navigate(
                        AppScreens.ReservationDetail(
                            bookTitle = reservation.bookTitle,
                            author = reservation.author,
                            reservationDate = reservation.date,
                            reservationCode = reservation.code,
                            status = reservation.status
                        )
                    )
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}