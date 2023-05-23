package com.example.CleanArchitecture.data.repository

import com.example.CleanArchitecture.data.base.BaseRepository
import com.example.CleanArchitecture.data.local.NoteDao
import com.example.CleanArchitecture.data.mapper.toEntity
import com.example.CleanArchitecture.data.mapper.toNote
import com.example.CleanArchitecture.domain.model.Note
import com.example.CleanArchitecture.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDAo: NoteDao
) : NoteRepository,
    BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDAo.createNote(note.toEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDAo.getAllNotes().map {
            it.toNote()
        }
    }


    override fun editNote(note: Note) = doRequest {
        noteDAo.editNote(note.toEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDAo.deleteNote(note.toEntity())
    }
}