package com.abulnes.trucker_app.domain.di


import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.abulnes.trucker_app.data.preferences.DefaultPreferences
import com.abulnes.trucker_app.data.service.AuthRepositoryImpl
import com.abulnes.trucker_app.domain.preferences.Preferences
import com.abulnes.trucker_app.domain.services.AuthRepository
import com.abulnes.trucker_app.domain.use_case.validators.ValidateEmail
import com.abulnes.trucker_app.domain.use_case.validators.ValidatePassword
import com.abulnes.trucker_app.domain.use_case.validators.ValidateSignUp
import com.abulnes.trucker_app.domain.use_case.validators.ValidatorsUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideFirebaseAuthentication(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideValidateEmail(): ValidateEmail {
        return ValidateEmail()
    }

    @Provides
    @Singleton
    fun provideValidatePassword(): ValidatePassword {
        return ValidatePassword()
    }

    @Provides
    @Singleton
    fun providesValidatorsUseCase(): ValidatorsUseCases {

        val validateEmail = ValidateEmail()
        val validatePassword = ValidatePassword()
        return ValidatorsUseCases(
            validateEmail = validateEmail,
            validatePassword = validatePassword,
            validateSignUp = ValidateSignUp(
                validatePassword = validatePassword,
                validateEmail = validateEmail
            )
        )
    }

    @Provides
    @Singleton
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
}