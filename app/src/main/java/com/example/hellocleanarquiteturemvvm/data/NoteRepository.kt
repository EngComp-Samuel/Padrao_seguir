package com.example.hellocleanarquiteturemvvm.data

import com.example.hellocleanarquiteturemvvm.domain.Note

interface NoteRepository {

    suspend fun getAllNotes(): List<Note>
    suspend fun addNote(note: Note)
    suspend fun deleteNote(noteId: Int)

}