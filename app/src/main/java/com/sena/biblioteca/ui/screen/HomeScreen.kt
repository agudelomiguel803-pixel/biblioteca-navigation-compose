package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sena.biblioteca.ui.navigation.AppScreens
import com.sena.biblioteca.ui.section.HomeActionsSection
import com.sena.biblioteca.ui.section.HomeHeaderSection

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
        // Sección Superior (Encabezado / Logo / Bienvenida)
        HomeHeaderSection()

        Spacer(modifier = Modifier.height(36.dp))

        // Sección Inferior (Botones de navegación)
        HomeActionsSection(
            onExploreClick = { navController.navigate(AppScreens.BookList) },
            onReservationsClick = { navController.navigate(AppScreens.MyReservations) }
        )
    }
}