package com.example.CleanArchitecture.presentation.utils.fragments.addNote

import com.example.CleanArchitecture.domain.model.Note
import com.example.CleanArchitecture.domain.usecase.CreateNoteUseCase
import com.example.CleanArchitecture.domain.usecase.EditNoteUseCase
import com.example.CleanArchitecture.presentation.base.BaseViewModel
import com.example.CleanArchitecture.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
): BaseViewModel() {

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    fun addNote(note: Note) {
        createNoteUseCase.createNote(note).collectFlow(_createNoteState)
    }

    fun editNote(note: Note){
        editNoteUseCase.editNote(note).collectFlow(_editNoteState)
    }
}