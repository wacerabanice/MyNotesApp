package com.banice.mynotes.add_edit_mynotes


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banice.mynotes.data.MyNotes
import com.banice.mynotes.data.MyNotesRepository
import com.banice.mynotes.util.UiEvent
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject


@HiltViewModel
class AddEditMyNotesViewModel @Inject constructor(
    private val repository: MyNotesRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var mynotes by mutableStateOf<MyNotes?>(null)
        private set

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        val mynotesId = savedStateHandle.get<Int>("mynotesId")!!
        if(mynotesId != -1) {
            viewModelScope.launch {
                repository.getMyNotesById(mynotesId)?.let { mynotes ->
                    title = mynotes.title
                    description = mynotes.description ?: ""
                    this@AddEditMyNotesViewModel.mynotes = mynotes
                }
            }
        }
    }

    fun onEvent(event: AddEditMyNotesEvent) {
        when(event) {
            is AddEditMyNotesEvent.OnTitleChange -> {
                title = event.title
            }
            is AddEditMyNotesEvent.OnDescriptionChange -> {
                description = event.description
            }
            is AddEditMyNotesEvent.OnSaveMyNotesClick -> {
                viewModelScope.launch {
                    if(title.isBlank()) {
                        sendUiEvent(
                            UiEvent.ShowSnackbar(
                                message = "The title can't be empty"
                            ))
                        return@launch
                    }
                    repository.insertMyNotes(
                        MyNotes(
                            title = title,
                            description = description,
                            isDone = mynotes?.isDone ?: false,
                            id = mynotes?.id
                        )
                    )
                    sendUiEvent(UiEvent.PopBackStack)
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}