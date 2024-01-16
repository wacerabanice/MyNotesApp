package com.banice.mynotes.di

import android.app.Application
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import androidx.room.Room
import com.banice.mynotes.data.MyNotesDatabase
import com.banice.mynotes.data.MyNotesRepository
import com.banice.mynotes.data.MyNotesRepositoryImpl
import dagger.Module

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyNotesDatabase(app: Application): MyNotesDatabase {
        return Room.databaseBuilder(
            app,
            MyNotesDatabase::class.java,
            "mynotes_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMyNotesRepository(db: MyNotesDatabase): MyNotesRepository {
        return MyNotesRepositoryImpl(db.dao)
    }
}