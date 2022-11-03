package com.kozak.glibrary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kozak.glibrary.data.model.ArtifactsModel
import com.kozak.glibrary.data.repository.ArtifactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtifactsViewModel(private val artifactsRepository: ArtifactsRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            artifactsRepository.getArtifacts()
        }
    }

    val artifacts: LiveData<ArtifactsModel>
    get() = artifactsRepository.artifacts
}