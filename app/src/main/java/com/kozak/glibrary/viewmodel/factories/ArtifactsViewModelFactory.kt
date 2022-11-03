package com.kozak.glibrary.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kozak.glibrary.data.repository.ArtifactsRepository
import com.kozak.glibrary.viewmodel.ArtifactsViewModel

class ArtifactsViewModelFactory(private val artifactsRepository: ArtifactsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtifactsViewModel(artifactsRepository) as T
    }
}