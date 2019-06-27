package com.example.picassoexemplo

import org.json.JSONObject

fun Fatiar(json: JSONObject): Match {
    return Match(
        json.getString("queue"),
        json.getString("championPNG"),
        json.getInt("kills"),
        json.getInt("deaths"),
        json.getInt("assists"),
        json.getInt("CS"),
        json.getString("win"),
        json.getString("item0URL"),
        json.getString("item1URL"),
        json.getString("item2URL"),
        json.getString("item3URL"),
        json.getString("item4URL"),
        json.getString("item5URL")
    )
}

data class Match(
    val queue: String,
    val championPNG: String,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val cs: Int,
    val win: String,
    val item0URL: String,
    val item1URL: String,
    val item2URL: String,
    val item3URL: String,
    val item4URL: String,
    val item5URL: String
)