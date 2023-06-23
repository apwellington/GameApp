package com.wete.gameapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.wete.gameapp.domain.model.Response

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>
    fun logout()
}