package com.sena.biblioteca.ui.section

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.runtime.Composable
import com.sena.biblioteca.ui.composable.PrimaryButton

@Composable
fun BookDetailActionsSection(
    onReserveClick: () -> Unit
) {
    PrimaryButton(
        text = "Reservar Libro",
        icon = Icons.Default.BookmarkAdded,
        onClick = onReserveClick
    )
}