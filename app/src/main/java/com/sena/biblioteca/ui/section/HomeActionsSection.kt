package com.sena.biblioteca.ui.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca.ui.composable.PrimaryButton

@Composable
fun HomeActionsSection(
    onExploreClick: () -> Unit,
    onReservationsClick: () -> Unit
) {
    // Usando el nuevo PrimaryButton atómico
    PrimaryButton(
        text = "Explorar Catálogo",
        icon = Icons.Default.Book,
        onClick = onExploreClick
    )

    Spacer(modifier = Modifier.height(12.dp))

    // Botón secundario bordeado
    OutlinedButton(
        onClick = onReservationsClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color(0xFF0D47A1)),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFF0D47A1)
        )
    ) {
        Icon(
            imageVector = Icons.Default.Bookmark,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = Color(0xFF0D47A1)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Ver mis Reservas",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}