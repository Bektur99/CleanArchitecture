package com.example.CleanArchitecture.data.mapper

import com.example.CleanArchitecture.data.model.NoteEntity
import com.example.CleanArchitecture.domain.model.Note

fun Note.toEntity() = NoteEntity(
    id, tittle, description
)

fun NoteEntity.toNote() = Note(
    id, tittle, description
)