package com.example.hellocleanarquiteturemvvm.domain

import com.example.hellocleanarquiteturemvvm.data.NoteRepository

class AddNotesUseCase(private val noteRepository: NoteRepository) {

    suspend fun addNote(note: Note) {
        noteRepository.addNote(note)
    }


}