package com.kozak.glibrary.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kozak.glibrary.data.api.ApiInterface
import com.kozak.glibrary.data.model.ArtifactsModel


class ArtifactsRepository(private val apiInterface: ApiInterface) {
    private val artifactsLiveData = MutableLiveData<ArtifactsModel>()
    val artifacts: LiveData<ArtifactsModel>
    get() = artifactsLiveData

    suspend fun getArtifacts() {
        val result = apiInterface.getArtifacts()
        if (result.body() != null) {
            artifactsLiveData.postValue(result.body())
        }
    }

}