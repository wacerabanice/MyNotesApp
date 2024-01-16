package com.banice.mynotes.data

import kotlinx.coroutines.flow.Flow


interface MyNotesRepository {

    suspend fun insertMyNotes(mynotes: MyNotes)

    suspend fun deleteMyNotes(mynotes: MyNotes)

    suspend fun getMyNotesById(id: Int): MyNotes?

    fun getMyNotes(): Flow<List<MyNotes>>
}