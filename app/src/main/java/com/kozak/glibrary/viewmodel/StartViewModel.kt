package com.kozak.glibrary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kozak.glibrary.data.model.CharactersModel
import com.kozak.glibrary.data.repository.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StartViewModel(private val charactersRepository: CharactersRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            charactersRepository.getCharacters()
        }
    }

    val characters: LiveData<CharactersModel>
    get() = charactersRepository.characters

}