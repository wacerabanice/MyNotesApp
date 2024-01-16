package com.banice.mynotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyNotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyNotes(mynotes: MyNotes)

    @Delete
    suspend fun deleteMyNotes(mynotes: MyNotes)

    @Query("SELECT * FROM mynotes WHERE id = :id")
    suspend fun getMyNotesById(id: Int): MyNotes?

    @Query("SELECT * FROM mynotes")
    fun getMyNotes(): Flow<List<MyNotes>>
}