package com.example.CleanArchitecture.domain.repository

import com.example.CleanArchitecture.domain.model.Note
import com.example.CleanArchitecture.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>
}