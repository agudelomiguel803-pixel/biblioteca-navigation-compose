package com.sena.biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.sena.biblioteca.ui.navigation.AppNavGraph
import com.sena.biblioteca.ui.theme.BibliotecaTheme // O el nombre de tu tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibliotecaTheme {
                // 1. Inicializamos el controlador de navegación
                val navController = rememberNavController()

                // 2. Cargamos nuestro grafo de navegación principal
                AppNavGraph(navController = navController)
            }
        }
    }
}