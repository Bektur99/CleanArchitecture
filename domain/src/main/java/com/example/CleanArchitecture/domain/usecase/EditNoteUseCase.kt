package com.example.CleanArchitecture.domain.usecase

import com.example.CleanArchitecture.domain.model.Note
import com.example.CleanArchitecture.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository,
    private val a: String,
) {

    fun editNote(note: Note) = noteRepository.editNote(note)
}
