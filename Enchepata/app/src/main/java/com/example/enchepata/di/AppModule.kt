package com.example.enchepata.di

import com.google.android.datatransport.runtime.dagger.Module
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.functions.dagger.Module
import com.google.firebase.functions.dagger.Provides
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.enchepata.data.AuthRepository
import com.example.enchepata.data.AuthRepositoryImpl
import com.google.firebase.ml.modeldownloader.dagger.Module

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
}