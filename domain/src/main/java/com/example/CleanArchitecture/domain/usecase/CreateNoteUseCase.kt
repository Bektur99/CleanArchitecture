package com.example.CleanArchitecture.domain.usecase

import com.example.CleanArchitecture.domain.model.Note
import com.example.CleanArchitecture.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun createNote(note: Note) = noteRepository.createNote(note)
}