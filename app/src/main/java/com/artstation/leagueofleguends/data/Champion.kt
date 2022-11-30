package com.artstation.leagueofleguends.data

import java.io.Serializable

data class Champion(
    val image: String,
    val name: String,
    val champion: ChampionsResponse.Champion?
) : Serializable