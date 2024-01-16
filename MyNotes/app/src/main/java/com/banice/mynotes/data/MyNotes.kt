package com.banice.mynotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
    data class MyNotes(
    val title: String,
    val description: String,
    val isDone: Boolean,
    @PrimaryKey val id: Int? = null
)