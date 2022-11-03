package com.kozak.glibrary.data.api

import com.kozak.glibrary.data.model.ArtifactsModel
import com.kozak.glibrary.data.model.CharactersModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/characters")
    suspend fun getCharacters(): Response<CharactersModel>

    @GET("/artifacts")
    suspend fun getArtifacts(): Response<ArtifactsModel>
}
