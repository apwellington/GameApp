package com.wete.gameapp.presentation.screen.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    var email: MutableState<String> = mutableStateOf("")

    var isValidEmail: MutableState<Boolean> = mutableStateOf(true)

    var emailError: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")

    var isValidPassword: MutableState<Boolean> = mutableStateOf(true)

    var passwordError: MutableState<String> = mutableStateOf("")

    var isEnableLoginButton =  false;


    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            isValidEmail.value = true
            emailError.value = ""
        }else {
            isValidEmail.value = false
            emailError.value = "Invalid Email"
        }
        enabledLoginButton()
    }


    fun validatePassword() {
        if (password.value.length >= 6) {
            isValidPassword.value = true
            passwordError.value = ""
        } else {
            isValidPassword.value = false
            passwordError.value = "Invalid Password"
        }
        enabledLoginButton()
    }

    fun enabledLoginButton() {
        isEnableLoginButton = isValidEmail.value && isValidPassword.value
    }
}