package com.abulnes.trucker_app.domain.di

import com.abulnes.trucker_app.domain.repository.AuthRepository
import com.abulnes.trucker_app.domain.use_case.authentication.Authenticate
import com.abulnes.trucker_app.domain.use_case.authentication.AuthenticationUseCases
import com.abulnes.trucker_app.domain.use_case.authentication.RegisterUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AuthenticationModule {
    @ViewModelScoped
    @Provides
    fun provideAuthenticationUseCases(authRepository: AuthRepository): AuthenticationUseCases {
        return AuthenticationUseCases(
            registerUser = RegisterUser(authRepository),
            authenticate = Authenticate(authRepository)
        )
    }
}