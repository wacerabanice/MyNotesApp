package com.banice.mynotes.mynotes_list

import androidx.compose.runtime.State
import com.banice.mynotes.data.MyNotes

sealed class MyNotesListEvent {


    data class OnDeleteMyNotesClick(val myNotes: MyNotes): MyNotesListEvent()
    data class OnDoneChange(val mynotes: MyNotes, val isDone: Boolean): MyNotesListEvent()
    object OnUndoDeleteClick: MyNotesListEvent()
    data class OnMyNotesClick(val mynotes: MyNotes): MyNotesListEvent()
    object OnAddMyNotesClick: MyNotesListEvent()
}