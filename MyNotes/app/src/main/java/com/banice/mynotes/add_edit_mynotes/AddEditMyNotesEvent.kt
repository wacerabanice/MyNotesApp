package com.banice.mynotes.add_edit_mynotes

sealed class AddEditMyNotesEvent {
    data class OnTitleChange(val title: String): AddEditMyNotesEvent()
    data class OnDescriptionChange(val description: String): AddEditMyNotesEvent()
    object OnSaveMyNotesClick: AddEditMyNotesEvent()
}