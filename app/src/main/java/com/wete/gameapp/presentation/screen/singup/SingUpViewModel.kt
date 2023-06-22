package com.wete.gameapp.presentation.screen.singup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingUpViewModel @Inject constructor(): ViewModel(){

    var username: MutableState<String> = mutableStateOf("")
    var isValidUsername: MutableState<Boolean> = mutableStateOf(true)
    var usernameError: MutableState<String> = mutableStateOf("")

    var email: MutableState<String> = mutableStateOf("")
    var isValidEmail: MutableState<Boolean> = mutableStateOf(true)
    var emailError: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isValidPassword: MutableState<Boolean> = mutableStateOf(true)
    var passwordError: MutableState<String> = mutableStateOf("")

    var passwordConfirm: MutableState<String> = mutableStateOf("")
    var isValidPasswordConfirm: MutableState<Boolean> = mutableStateOf(true)
    var passwordConfirmError: MutableState<String> = mutableStateOf("")



    var isEnableSingUpButton =  false;

    fun validateUserName(){
        if(username.value.length >= 6){
            isValidUsername.value = true
            usernameError.value = ""
        }else {
            isValidUsername.value = false
            usernameError.value = "Invalid UserName"
        }
        enabledSingUpButton()
    }


    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            isValidEmail.value = true
            emailError.value = ""
        }else {
            isValidEmail.value = false
            emailError.value = "Invalid Email"
        }
        enabledSingUpButton()
    }


    fun validatePassword() {
        if (password.value.length >= 6) {
            isValidPassword.value = true
            passwordError.value = ""
        } else {
            isValidPassword.value = false
            passwordError.value = "Invalid Password"
        }
        enabledSingUpButton()
    }

    fun validatePasswordConfirm() {
        if (passwordConfirm.value.length >= 6) {
            isValidPasswordConfirm.value = true
            passwordConfirmError.value = ""
        } else {
            isValidPasswordConfirm.value = false
            passwordConfirmError.value = "Invalid Password"
        }
        enabledSingUpButton()
    }

    fun enabledSingUpButton() {
        isEnableSingUpButton =
            isValidEmail.value && isValidPassword.value && isValidUsername.value && isValidPasswordConfirm.value && password.value == passwordConfirm.value
    }
}