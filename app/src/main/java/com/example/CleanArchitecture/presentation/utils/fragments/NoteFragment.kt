package com.example.CleanArchitecture.presentation.utils.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.CleanArchitecture.R
import com.example.CleanArchitecture.databinding.ActivityMainBinding
import com.example.CleanArchitecture.presentation.utils.UIState
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch

@HiltAndroidApp
class NoteFragment : Fragment(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val viewModel by viewModels<NotesViewModel>()
    private lateinit var a: ActivityMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupSubscribers()
        setupRequests()
        initListeners()
    }

    @Suppress("DEPRECATION")
    private fun initListeners() {
        requireArguments().getSerializable("key")
    }

    private fun setupRequests() {
        viewModel.getAllNotes()
    }

    private fun setupSubscribers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllNotesState.collect { state ->
                    when (state) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                        is UIState.Loading -> {
                            // TODO(show progress bar)
                        }
                        is UIState.Success -> {
                            // TODO(submit list to adapter)
                        }
                    }
                }
            }
        }
    }

    private fun initialize() {

    }
}