package com.wete.gameapp.domain.usecase.auth


import com.wete.gameapp.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) = repo.login(email, password)
}