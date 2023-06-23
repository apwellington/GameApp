package com.wete.gameapp.di

import com.google.firebase.auth.FirebaseAuth
import com.wete.gameapp.data.repository.AuthRepositoryImpl
import com.wete.gameapp.domain.repository.AuthRepository
import com.wete.gameapp.domain.usecase.auth.AuthUseCases
import com.wete.gameapp.domain.usecase.auth.GetCurrentUser
import com.wete.gameapp.domain.usecase.auth.Login
import com.wete.gameapp.domain.usecase.auth.Logout
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideAuthUseCases(repo: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repo),
        login = Login(repo),
        logout = Logout(repo)
    )




}