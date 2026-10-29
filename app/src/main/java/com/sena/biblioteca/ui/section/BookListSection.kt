package com.sena.biblioteca.ui.section

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.sena.biblioteca.ui.screen.BookItem

@Composable
fun BookListSection(
    books: List<BookItem>,
    onBookClick: (BookItem) -> Unit
) {
    LazyColumn {
        items(books) { book ->
            BookCardSection(
                book = book,
                onDetailClick = { onBookClick(book) }
            )
        }
    }
}