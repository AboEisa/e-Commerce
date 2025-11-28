package com.example.e_commerce.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce.presentation.login.LoginScreen
import com.example.e_commerce.presentation.register.RegisterScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

        val context: Context = LocalContext.current
    // Check if the user is logged in
    val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
    val startDestination = if (isLoggedIn) "home" else "login"


    val navController = rememberNavController()


    NavHost(navController = navController , startDestination = startDestination){
        composable("login"){
            LoginScreen(navController)
        }
        composable("register"){
            RegisterScreen(navController)
        }

    }




}
