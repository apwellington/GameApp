package com.wete.gameapp.presentation.screen.singup

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.wete.gameapp.presentation.components.DefaultSingUpToolBar
import com.wete.gameapp.presentation.screen.singup.components.SingUpContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun SingupScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = { DefaultSingUpToolBar(title = "SingUp", upAvailable = true, navHostController = navHostController) },
        content = {
                  SingUpContent()
        },
        bottomBar = {  }
    )

}


@ExperimentalMaterial3Api
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SingupScreenPreview() {
    SingupScreen(navHostController = rememberNavController())
}