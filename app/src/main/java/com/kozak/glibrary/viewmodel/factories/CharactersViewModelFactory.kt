package com.kozak.glibrary.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kozak.glibrary.data.repository.CharactersRepository
import com.kozak.glibrary.viewmodel.CharactersViewModel

class CharactersViewModelFactory(private val charactersRepository: CharactersRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharactersViewModel(charactersRepository) as T
    }
}