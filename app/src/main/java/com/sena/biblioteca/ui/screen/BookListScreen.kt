package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Castle
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sena.biblioteca.ui.navigation.AppScreens

// Modelo de datos con ícono y color individual por libro
data class BookItem(
    val id: Int,
    val title: String,
    val author: String,
    val category: String,
    val description: String,
    val icon: ImageVector,
    val iconColor: Color
)

// Los 5 libros
val sampleBooks = listOf(
    BookItem(
        id = 1,
        title = "Harry Potter y la piedra filosofal",
        author = "J.K. Rowling",
        category = "Fantasía / Juvenil",
        description = "La historia del joven mago que descubre su verdadero destino al ingresar a la escuela de magia y hechicería de Hogwarts.",
        icon = Icons.Default.AutoAwesome,
        iconColor = Color(0xFF7B1FA2)
    ),
    BookItem(
        id = 2,
        title = "Alicia en el país de las maravillas",
        author = "Lewis Carroll",
        category = "Fantasía / Clásico Animado",
        description = "Un viaje surrealista a través de un mundo mágico lleno de personajes excéntricos, un gato sonriente y un sombrerero loco.",
        icon = Icons.Default.Book,
        iconColor = Color(0xFF1E88E5)
    ),
    BookItem(
        id = 3,
        title = "Las Crónicas de Narnia",
        author = "C.S. Lewis",
        category = "Aventura / Fantasía",
        description = "Cuatro hermanos descubren un mundo mágico oculto dentro de un ropero viejo, gobernado por un león llamado Aslan.",
        icon = Icons.Default.Castle,
        iconColor = Color(0xFF388E3C)
    ),
    BookItem(
        id = 4,
        title = "Peter Pan",
        author = "J.M. Barrie",
        category = "Aventura / Clásico",
        description = "Las aventuras del niño que nunca quiso crecer, Wendy y sus hermanos en el fantástico mundo de Nunca Jamás.",
        icon = Icons.Default.Star,
        iconColor = Color(0xFFF57C00)
    ),
    BookItem(
        id = 5,
        title = "Coraline",
        author = "Neil Gaiman",
        category = "Fantasía Oscura / Animación",
        description = "Una niña descubre una puerta secreta en su nueva casa que la lleva a una versión aparentemente mejor de su vida, pero con un secreto siniestro.",
        icon = Icons.Default.Bookmark,
        iconColor = Color(0xFFD32F2F)
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = null,
                            tint = Color(0xFF0D47A1)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Mis Libros",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF111111)
                        )
                    }
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
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Elige un libro para ver más detalles.",
                fontSize = 17.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 12.dp, top = 8.dp)
            )

            LazyColumn {
                items(sampleBooks) { book ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFF8F9FA)
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Caja contenedora con color temático suave al 15% de opacidad
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .background(
                                        color = book.iconColor.copy(alpha = 0.15f),
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = book.icon,
                                    contentDescription = null,
                                    tint = book.iconColor,
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            // Título del libro
                            Text(
                                text = book.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color(0xFF111111),
                                modifier = Modifier.weight(1f)
                            )

                            // Botón Ver Detalle
                            Button(
                                onClick = {
                                    navController.navigate(
                                        AppScreens.BookDetail(
                                            title = book.title,
                                            author = book.author,
                                            category = book.category,
                                            description = book.description
                                        )
                                    )
                                },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF0D47A1)
                                ),
                                modifier = Modifier.padding(start = 4.dp)
                            ) {
                                Text(
                                    text = "Ver Detalle",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}