package com.example.hellocleanarquiteturemvvm.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.hellocleanarquiteturemvvm.domain.Note
import com.example.hellocleanarquiteturemvvm.presentation.NoteViewModel


@Composable
fun NoteScreen(noteViewModel: NoteViewModel, modifier: Modifier = Modifier){
    val notes by noteViewModel.notes.collectAsState()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    noteViewModel.addNote(
                        Note(
                            id = notes.size+1,
                            title = "New Note ${notes.size+1}",
                            content = "This is a new note = 3333",
                            timestamp = System.currentTimeMillis()
                        )
                    )
                }
            ){
                Text(text = "+")
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding),) {
            items(notes) { note -> Text(text = note.title)
            }
        }
    }
}