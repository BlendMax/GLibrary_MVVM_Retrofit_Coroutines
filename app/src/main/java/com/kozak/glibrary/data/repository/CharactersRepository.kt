package com.kozak.glibrary.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kozak.glibrary.data.api.ApiInterface
import com.kozak.glibrary.data.model.CharactersModel

class CharactersRepository(private val apiInterface: ApiInterface) {
    private val charactersLiveData = MutableLiveData<CharactersModel>()
    val characters: LiveData<CharactersModel>
    get() = charactersLiveData

    suspend fun getCharacters(){
        val result = apiInterface.getCharacters()
        if (result.body() != null){
            charactersLiveData.postValue(result.body())
        }
    }
}