package com.wete.gameapp.presentation.screen.login

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.wete.gameapp.presentation.screen.login.componet.LoginBottomBar
import com.wete.gameapp.presentation.screen.login.componet.LoginContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun LoginScreen(navHostController: NavHostController) {


    Scaffold(
        topBar = {},
        content = {
            LoginContent(navHostController)
        },
        bottomBar = {
            LoginBottomBar(navHostController = navHostController)
        }
    )
}