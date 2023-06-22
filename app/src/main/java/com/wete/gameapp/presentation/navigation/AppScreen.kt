package com.wete.gameapp.presentation.navigation

sealed class AppScreen(val route: String) {
    object Login: AppScreen(route ="login")
    object Singup: AppScreen(route ="singup")
}
