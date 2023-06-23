package com.wete.gameapp.presentation.screen.profile

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.wete.gameapp.presentation.components.DefaultButton
import com.wete.gameapp.presentation.navigation.AppScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(navHostController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {},
        content = {
            DefaultButton(text = "Logout", modifier = Modifier,  onClick = {
                viewModel.logout()
                navHostController.navigate(AppScreen.Login.route){
                    popUpTo(AppScreen.Profile.route){inclusive = true}
                }
            })
        },
        bottomBar = {}
    )
}