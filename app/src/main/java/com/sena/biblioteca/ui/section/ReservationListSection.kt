package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca.ui.composable.InfoBadge
import com.sena.biblioteca.ui.composable.PrimaryButton
import com.sena.biblioteca.ui.screen.ReservationItem

@Composable
fun ReservationListSection(
    reservations: List<ReservationItem>,
    onViewDetail: (ReservationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(reservations) { reservation ->
            ReservationCard(
                reservation = reservation,
                onViewDetail = { onViewDetail(reservation) }
            )
        }
    }
}

@Composable
fun ReservationCard(
    reservation: ReservationItem,
    onViewDetail: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FA)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(text = "Libro:", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
            Text(text = reservation.bookTitle, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Fecha:", fontSize = 15.sp, color = Color.Black)
                Text(text = reservation.date, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Estado:", fontSize = 15.sp, color = Color.Black)
                // Usando InfoBadge en lugar del Box manual
                InfoBadge(text = reservation.status)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Usando PrimaryButton en lugar del Button manual
            PrimaryButton(
                text = "Ver Reserva",
                icon = Icons.Default.Visibility,
                onClick = onViewDetail
            )
        }
    }
}