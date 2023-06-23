package com.wete.gameapp.domain.usecase.auth

import com.wete.gameapp.domain.repository.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val authRepository: AuthRepository) {
    operator fun invoke() = authRepository.logout()
}