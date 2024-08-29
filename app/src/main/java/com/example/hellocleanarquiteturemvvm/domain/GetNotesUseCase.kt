package com.example.hellocleanarquiteturemvvm.domain

import com.example.hellocleanarquiteturemvvm.data.NoteRepository

class GetNotesUseCase(private val noteRepository: NoteRepository) {

    suspend fun getNotes(): List<Note> {
        return noteRepository.getAllNotes()
    }

}