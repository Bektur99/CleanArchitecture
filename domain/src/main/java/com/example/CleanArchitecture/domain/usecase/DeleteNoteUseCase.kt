package com.example.CleanArchitecture.domain.usecase

import com.example.CleanArchitecture.domain.model.Note
import com.example.CleanArchitecture.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}