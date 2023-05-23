package com.example.CleanArchitecture.presentation.utils.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.CleanArchitecture.domain.model.Note
import com.example.CleanArchitecture.domain.usecase.DeleteNoteUseCase
import com.example.CleanArchitecture.domain.usecase.GetAllNotesUseCase
import com.example.CleanArchitecture.domain.utils.Resource
import com.example.CleanArchitecture.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNotesUseCase: DeleteNoteUseCase,
): ViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    fun getAllNotes() {
        viewModelScope.launch {
            getAllNotesUseCase.getAllNotes().collect { res ->
                when (res) {
                    is Resource.Error -> {
                        _getAllNotesState.value = UIState.Error(res.message!!)
                    }
                    is Resource.Loading -> {
                        _getAllNotesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (res.data != null) {
                            _getAllNotesState.value = UIState.Success(res.data!!)
                        }
                    }
                }
            }
        }
    }
}