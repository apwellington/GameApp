package com.wete.gameapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wete.gameapp.presentation.ui.theme.Red500

@ExperimentalMaterial3Api
@Composable
fun DefaultSingUpToolBar(
    title: String,
    upAvailable: Boolean = false,
    navHostController: NavHostController? = null,
    iconColor: Color = Color.White
) {
    TopAppBar(
        title = {
            Text(text = title, fontSize = 19.sp)
        },
        navigationIcon = {
            if(upAvailable){
                IconButton(onClick = { navHostController?.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", tint = iconColor)
                }
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Red500,
            navigationIconContentColor = Color.White, titleContentColor = Color.White),
    )
}

@ExperimentalMaterial3Api
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultSingUpToolBarPreview() {
    DefaultSingUpToolBar(title = "SingUp", upAvailable = true)
}