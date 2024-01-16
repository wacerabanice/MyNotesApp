package com.banice.notedown.di

import android.app.Application
import androidx.compose.ui.tooling.data.UiToolingDataApi
import com.banice.notedown.NoteDownApp


@UiToolingDataApi
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDownDatabase(app: Application): NoteDownDatabase{

        return Room.databaseBuilder(
            app,
            NoteDownDatabase::class.java,
            "notedown_db"
        ).build()


    }
}