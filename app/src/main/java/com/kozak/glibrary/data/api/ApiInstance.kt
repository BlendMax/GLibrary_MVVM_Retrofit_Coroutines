package com.kozak.glibrary.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


 object ApiInstance {
        private const val baseUrl = "https://api.genshin.dev/"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
 }
