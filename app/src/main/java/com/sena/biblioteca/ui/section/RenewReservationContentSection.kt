package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RenewReservationContentSection(
    bookTitle: String,
    currentDate: String,
    newDate: String,
    onNewDateChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FA))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Libro:", fontSize = 13.sp, color = Color.Gray)
                Text(text = bookTitle, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Reserva Actual:", fontSize = 13.sp, color = Color.Gray)
                Text(text = currentDate, fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.Black)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Nueva Fecha:", fontSize = 13.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = newDate,
                    onValueChange = onNewDateChange,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                )
            }
        }
    }
}