package net.pata.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.pata.ui.theme.about.AboutScreen
import net.pata.ui.theme.add.Addscreen
import net.pata.ui.theme.auth.AuthViewModel
import net.pata.ui.theme.auth.LoginScreen
import net.pata.ui.theme.auth.RegisterScreen
import net.pata.ui.theme.home.HomeScreen


@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(viewModel, navController)
        }
        composable(ROUTE_ADDDATA) {
            Addscreen(viewModel, navController)
        }
    }
}