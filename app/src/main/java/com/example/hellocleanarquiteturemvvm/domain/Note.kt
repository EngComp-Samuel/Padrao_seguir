package com.example.hellocleanarquiteturemvvm.domain

data class Note(
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long
)
