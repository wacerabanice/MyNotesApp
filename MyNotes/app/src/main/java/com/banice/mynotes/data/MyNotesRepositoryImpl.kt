package com.banice.mynotes.data

import kotlinx.coroutines.flow.Flow


class MyNotesRepositoryImpl(
    private val dao: MyNotesDao
): MyNotesRepository {

    override suspend fun insertMyNotes(mynotes: MyNotes) {
        dao.insertMyNotes(mynotes)
    }

    override suspend fun deleteMyNotes(mynotes: MyNotes) {
        dao.deleteMyNotes(mynotes)
    }

    override suspend fun getMyNotesById(id: Int): MyNotes? {
        return dao.getMyNotesById(id)
    }

    override fun getMyNotes(): Flow<List<MyNotes>> {
        return dao.getMyNotes()
    }
}