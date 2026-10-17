package ir.aotol.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.aotol.app.ui.pages.SplashPage

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Splash") {
        composable(route = "Splash") { SplashPage(navController) }
    }
}