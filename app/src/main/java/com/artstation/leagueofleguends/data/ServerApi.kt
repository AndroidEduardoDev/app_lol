package com.artstation.leagueofleguends.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ServerApi {
    @GET
    suspend fun getChampions(@Url url: String): Response<ChampionsResponseServer>

    
}