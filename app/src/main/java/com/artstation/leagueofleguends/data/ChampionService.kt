package com.artstation.leagueofleguends.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.CoroutineScope as CoroutineScope1

class ChampionService {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ddragon.leagueoflegends.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun getChampion() {
        CoroutineScope1(Dispatchers.IO).launch {
            val call = getRetrofit().create(ChampionApi::class.java)
                .getChampions("cdn/12.22.1/data/es_ES/champion.json")

            if (call != null)
                Log.d("ayush: ", call.body().toString())
        }
    }
}