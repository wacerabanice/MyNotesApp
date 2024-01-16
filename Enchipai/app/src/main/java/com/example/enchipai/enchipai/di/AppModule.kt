package com.example.enchipai.enchipai.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.enchipai.enchipai.data.AuthRepository
import com.example.enchipai.enchipai.data.AuthRepositoryImpl
import com.google.firebase.functions.dagger.Module
import com.google.firebase.functions.dagger.Provides


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
}