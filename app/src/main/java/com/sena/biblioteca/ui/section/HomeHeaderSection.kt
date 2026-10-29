package com.sena.biblioteca.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
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
fun HomeHeaderSection() {
    // Círculo con Icono
    Box(
        modifier = Modifier
            .size(130.dp)
            .background(
                color = Color(0xFFE8EAF6),
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.MenuBook,
            contentDescription = "Logo Biblioteca",
            modifier = Modifier.size(65.dp),
            tint = Color(0xFF0D47A1)
        )
    }

    Spacer(modifier = Modifier.height(28.dp))

    // Título de bienvenida
    Text(
        text = "¡Bienvenido a la\nBiblioteca Bichonciego!",
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = Color(0xFF111111),
        lineHeight = 30.sp
    )

    Spacer(modifier = Modifier.height(12.dp))

    // Subtítulo
    Text(
        text = "Descubre, aprende y reserva\ntus libros favoritos.",
        fontSize = 17.sp,
        textAlign = TextAlign.Center,
        color = Color.Black,
        lineHeight = 20.sp
    )
}