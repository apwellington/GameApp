package com.wete.gameapp.domain.usecase.auth

import com.wete.gameapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repo: AuthRepository) {
    operator fun invoke() = repo.currentUser
}