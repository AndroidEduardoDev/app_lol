package com.artstation.leagueofleguends.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChampionsResponse(
    @SerializedName("type") val type: String,
    @SerializedName("format") val format: String,
    @SerializedName("version") val version: String,
    @SerializedName("data") val data: Map<String, Champion>
) : Serializable {

    data class Champion(
        val version: String,
        val id: String,
        val key: String,
        val name: String,
        val title: String,
        val blurb: String,
        val info: Info,
        val image: Image,
        val tags: List<String>,
        val partype: String,
        val stats: Map<String, Double>
    ) : Serializable {
        data class Image(
            val full: String,
            val sprite: String,
            val group: String,
            val x: Long,
            val y: Long,
            val w: Long,
            val h: Long
        ) : Serializable

        data class Info(
            val attack: Long,
            val defense: Long,
            val magic: Long,
            val difficulty: Long
        ) : Serializable
    }


}





