package com.example.hellocleanarquiteturemvvm.data

import com.example.hellocleanarquiteturemvvm.domain.Note

class NoteRepositoryImpl(private val localDataSource: NoteDataSource): NoteRepository {

    override suspend fun getAllNotes(): List<Note> {
        return localDataSource.getAllNotes()
    }

    override suspend fun addNote(note: Note) {
        localDataSource.addNote(note)
    }

    override suspend fun deleteNote(noteId: Int) {
        localDataSource.deleteNote(noteId)
    }


}