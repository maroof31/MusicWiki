package com.example.musicwiki.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


//    Application name	MusicWiki
//    API key	49defa730b781a600750beb5020a90de
//    Shared secret	b71b46c00b8811a7049e1957042fef90
//    Registered to	mrf31



    val api : genreApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://ws.audioscrobbler.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(genreApi::class.java)
    }
}