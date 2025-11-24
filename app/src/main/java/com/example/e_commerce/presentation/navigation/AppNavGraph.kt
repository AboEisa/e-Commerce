package com.example.e_commerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.e_commerce.presentation.login.LoginScreen
import com.example.e_commerce.presentation.register.RegisterScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "login"   // 👈 Login is first
    ) {

        composable("login") {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable("register") {
            RegisterScreen(
                onLoginClick = {
                    navController.navigate("login")
                }
            )
        }
    }
}
