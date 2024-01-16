package com.banice.notedown.dao

import kotlinx.coroutines.flow.Flow

interface dao {
    suspend fun insertNote (Note: note)
    suspend fun deleteNote (Note: note)
    suspend fun getNoteById(Id: Int): Note?
    fun getNotes(): Flow<List<Note>>
}