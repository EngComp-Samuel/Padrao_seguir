package com.example.hellocleanarquiteturemvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hellocleanarquiteturemvvm.domain.AddNotesUseCase
import com.example.hellocleanarquiteturemvvm.domain.GetNotesUseCase
import com.example.hellocleanarquiteturemvvm.domain.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteViewModel (
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNotesUseCase,
    //private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    private val _contator = MutableStateFlow(0)
    val contadores: StateFlow<Int> = _contator

    init {
        loadNotes()
    }

    fun loadNotes() {
        viewModelScope.launch {
            _notes.value = getNotesUseCase.getNotes()
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            _contator.value += 1
            addNoteUseCase.addNote(note = note)
            loadNotes()
        }
    }
}