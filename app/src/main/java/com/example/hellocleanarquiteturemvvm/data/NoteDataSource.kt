package com.example.hellocleanarquiteturemvvm.data

import com.example.hellocleanarquiteturemvvm.domain.Note

interface NoteDataSource {

    suspend fun getAllNotes(): List<Note>
    suspend fun addNote(note: Note)
    suspend fun deleteNote(noteId: Int)

}


class LocalNoteDataSource : NoteDataSource{

    private val notes = mutableListOf<Note>()

    override suspend fun getAllNotes(): List<Note> = notes

    override suspend fun addNote(note: Note) {
        notes.add(note)
    }

    override suspend fun deleteNote(noteId: Int) {
        notes.removeAll {
            it.id == noteId
        }
    }


}