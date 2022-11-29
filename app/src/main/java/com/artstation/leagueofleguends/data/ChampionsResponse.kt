package com.artstation.leagueofleguends.data

import com.google.gson.annotations.SerializedName

data class ChampionsResponse(
    @SerializedName("type") val type: String,
    @SerializedName("format") val format: String,
    @SerializedName("version") val version: String,
    @SerializedName("data") val data: Map<String, Champion>
) {

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
    ) {
        data class Image(
            val full: String,
            val sprite: String,
            val group: String,
            val x: Long,
            val y: Long,
            val w: Long,
            val h: Long
        )

        data class Info(
            val attack: Long,
            val defense: Long,
            val magic: Long,
            val difficulty: Long
        )
    }


}





