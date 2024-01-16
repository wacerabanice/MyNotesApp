package com.banice.mynotes.data

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(
    entities = [MyNotes::class],
    version = 1
)
abstract class MyNotesDatabase: RoomDatabase() {

    abstract val dao: MyNotesDao
}