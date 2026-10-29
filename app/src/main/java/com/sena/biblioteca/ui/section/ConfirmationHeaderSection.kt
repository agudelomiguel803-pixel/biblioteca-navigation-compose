package com.sena.biblioteca.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmationHeaderSection(
    bookTitle: String,
    reservationCode: String,
    date: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        // Ícono de éxito animado/destacado
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(
                    color = Color(0xFFE8F5E9),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Éxito",
                modifier = Modifier.size(54.dp),
                tint = Color(0xFF2E7D32)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "¡Reserva Exitosa!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF111111)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Tu libro ha sido apartado correctamente en el sistema.",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Tarjeta comprobante con los detalles de la reserva
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF8F9FA)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "COMPROBANTE DE RESERVA",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0D47A1),
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = bookTitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF111111)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Fila de Código
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Código de reserva:", fontSize = 15.sp, color = Color.Black)
                    Text(text = reservationCode, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF111111))
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Fila de Fecha
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Fecha de reclamo:", fontSize = 15.sp, color = Color.Black)
                    Text(text = date, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF111111))
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Ícono simulador de QR / Código de barras
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color(0xFFE8EAF6), shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.QrCode,
                            contentDescription = null,
                            tint = Color(0xFF0D47A1)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Presenta este código en la biblioteca",
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}