package net.pata.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.pata.data.AuthRepository
import net.pata.data.AuthRepositoryImpl
import net.pata.data.local.PreviousOperationDao
import net.pata.data.local.PreviousOperationDatabase
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
}


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providePreviousOperationDatabase(
        @ApplicationContext app: Context,
    ): PreviousOperationDatabase {
        return Room.databaseBuilder(
            app,
            PreviousOperationDatabase::class.java,
            "calculator_history_database",
        ).createFromAsset("database/previous_operation.db").build()
    }

    @Singleton
    @Provides
    fun providePreviousOperationDao(previousOperationDatabase: PreviousOperationDatabase):
            PreviousOperationDao {
        return previousOperationDatabase.getPreviousOperationDao()
    }
}
