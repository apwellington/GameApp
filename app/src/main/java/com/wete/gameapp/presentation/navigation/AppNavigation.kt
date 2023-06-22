package com.wete.gameapp.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wete.gameapp.presentation.screen.login.LoginScreen
import com.wete.gameapp.presentation.screen.singup.SingupScreen

@ExperimentalMaterial3Api
@Composable
fun AppNavigation(navController: NavHostController) {
    
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route // especifica la primer pantalla que se va a mostrar
    ){
        composable(route = AppScreen.Login.route){
            LoginScreen(navHostController = navController)
        }

        composable(route = AppScreen.Singup.route){
            SingupScreen(navHostController = navController)
        }
    }

}