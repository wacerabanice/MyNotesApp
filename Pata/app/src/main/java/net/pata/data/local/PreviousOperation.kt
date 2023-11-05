package net.pata.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import net.pata.data.local.PreviousOperationDao

@Database(entities = [PreviousOperation::class], version = 1, exportSchema = false)
abstract class PreviousOperationDatabase : RoomDatabase() {

    abstract fun getPreviousOperationDao(): PreviousOperationDao
}