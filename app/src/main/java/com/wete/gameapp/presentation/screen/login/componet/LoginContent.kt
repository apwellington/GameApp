package com.wete.gameapp.presentation.screen.login.componet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wete.gameapp.R
import com.wete.gameapp.presentation.components.DefaultButton
import com.wete.gameapp.presentation.components.DefaultOutlineTextField
import com.wete.gameapp.presentation.ui.theme.DarkGray500
import com.wete.gameapp.presentation.ui.theme.Red500

@ExperimentalMaterial3Api
@Composable
fun LoginContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        BoxHeader()
        LoginCardComponent()
    }
}

@ExperimentalMaterial3Api
@Composable
fun LoginCardComponent() {

    var email by remember {
        mutableStateOf("")
    }

    var pass by remember {
        mutableStateOf("")
    }

    Card(
        modifier = Modifier
        .padding(start = 40.dp, end = 40.dp, top = 200.dp)
        .background(color = DarkGray500),
        ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 40.dp, start = 0.dp, end = 0.dp, bottom = 0.dp),
                text = "LOGIN",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Inicia Sesion Para Continuar",
                fontSize = 18.sp,
                color = Color.Gray,
            )


            DefaultOutlineTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = email,
                onValueChange = {email = it},
                text ="Email",
                icon = Icons.Default.Email,
                keyBoarType = KeyboardType.Email
            )

            DefaultOutlineTextField(
                modifier = Modifier.padding(top = 5.dp),
                value = pass,
                onValueChange = {pass = it},
                text ="Password",
                icon = Icons.Default.Lock,
                hideText = true,
                keyBoarType = KeyboardType.Password
            )
            
            DefaultButton(
                text = "Login",
                onClick = { }
            )
        }
    }
}

@Composable
fun BoxHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Red500)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .height(130.dp),
                painter = painterResource(id = R.drawable.control),
                contentDescription = "Control"
            )
            Text(
                text = "Gamer APP"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   LoginContent()
}