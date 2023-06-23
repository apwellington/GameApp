package com.wete.gameapp.domain.usecase.auth

data class AuthUseCases (
    val getCurrentUser: GetCurrentUser,
    val login: Login,
    val logout: Logout
)