package com.wete.gameapp.presentation.screen.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.wete.gameapp.domain.model.Response
import com.wete.gameapp.domain.usecase.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {

    var email: MutableState<String> = mutableStateOf("")

    var isValidEmail: MutableState<Boolean> = mutableStateOf(true)

    var emailError: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")

    var isValidPassword: MutableState<Boolean> = mutableStateOf(true)

    var passwordError: MutableState<String> = mutableStateOf("")

    var isEnableLoginButton =  false;

    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(value = null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginFlow

    val currentUser = authUseCases.getCurrentUser()
    init {
        if(currentUser != null){
            _loginFlow.value = Response.Success(currentUser)
        }
    }




    fun login() = viewModelScope.launch {
        _loginFlow.value = Response.Loading
        val result = authUseCases.login(email.value, password.value)
        _loginFlow.value = result
    }


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