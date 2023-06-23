package com.wete.gameapp.presentation.screen.profile

import androidx.lifecycle.ViewModel
import com.wete.gameapp.domain.usecase.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {
    fun logout() = authUseCases.logout()
}