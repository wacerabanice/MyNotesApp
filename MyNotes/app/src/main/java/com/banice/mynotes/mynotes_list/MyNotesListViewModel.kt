package com.banice.mynotes.mynotes_list



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banice.mynotes.data.MyNotes
import com.banice.mynotes.data.MyNotesRepository
import com.banice.mynotes.util.Routes
import com.banice.mynotes.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject




@HiltViewModel
class MyNotesListViewModel @Inject constructor(
    private val repository: MyNotesRepository
): ViewModel() {

    val mynotes = repository.getMyNotes()


    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var deletedMyNotes: MyNotes? = null

    fun onEvent(event: MyNotesListEvent) {
        when(event) {
            is MyNotesListEvent.OnMyNotesClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_MYNOTES + "?mynotesId=${event.mynotes.id}"))
            }
            is MyNotesListEvent.OnAddMyNotesClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_MYNOTES))
            }
            is MyNotesListEvent.OnUndoDeleteClick -> {
                deletedMyNotes?.let { mynotes ->
                    viewModelScope.launch {
                        repository.insertMyNotes(mynotes)
                    }
                }
            }
            is MyNotesListEvent.OnDeleteMyNotesClick -> {
                viewModelScope.launch {
                    deletedMyNotes = event.myNotes
                    repository.deleteMyNotes(event.myNotes)
                    sendUiEvent(UiEvent.ShowSnackbar(
                        message = "MyNotes deleted",
                        action = "Undo"
                    ))
                }
            }
            is MyNotesListEvent.OnDoneChange -> {
                viewModelScope.launch {
                    repository.insertMyNotes(
                        event.mynotes.copy(
                            isDone = event.isDone
                        )
                    )
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