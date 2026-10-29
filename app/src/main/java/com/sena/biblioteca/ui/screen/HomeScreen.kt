package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sena.biblioteca.ui.navigation.AppScreens

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
                tint = Color(0xFF0D47A1) // Azul marino oscuro
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

        Spacer(modifier = Modifier.height(36.dp))

        // Botón Explorar Catálogo
        Button(
            onClick = { navController.navigate(AppScreens.BookList) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0D47A1) // Azul oscuro sobrio
            )
        ) {
            Icon(
                imageVector = Icons.Default.Book,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Explorar Catálogo",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Botón Ver mis Reservas
        OutlinedButton(
            onClick = { navController.navigate(AppScreens.MyReservations) },
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
}