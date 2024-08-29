package com.example.hellocleanarquiteturemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hellocleanarquiteturemvvm.data.LocalNoteDataSource
import com.example.hellocleanarquiteturemvvm.data.NoteRepositoryImpl
import com.example.hellocleanarquiteturemvvm.domain.AddNotesUseCase
import com.example.hellocleanarquiteturemvvm.domain.GetNotesUseCase
import com.example.hellocleanarquiteturemvvm.presentation.NoteViewModel
import com.example.hellocleanarquiteturemvvm.presentation.ui.NoteScreen
import com.example.hellocleanarquiteturemvvm.ui.theme.HelloCleanArquitetureMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            //inicializa a camada de dados
            val dataSource = LocalNoteDataSource()
            val repository = NoteRepositoryImpl(dataSource)

            //inicializa a camada de dominio
            val getNotesUseCase = GetNotesUseCase(repository)
            val addNotesUseCase = AddNotesUseCase(repository)

            //inicializa o viewModel
            val viewModel = NoteViewModel(getNotesUseCase, addNotesUseCase)

            HelloCleanArquitetureMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NoteScreen(
                        noteViewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}