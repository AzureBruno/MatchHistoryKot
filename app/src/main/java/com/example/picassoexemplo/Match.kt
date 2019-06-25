package com.example.picassoexemplo

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Match (val championPNG : String,
                  val kills : Int,
                  val deaths : Int,
                  val assists : Int,
                  val cs : Int,
                  val win : String,
                  val item0URL : String,
                  val item1URL : String,
                  val item2URL : String,
                  val item3URL : String,
                  val item4URL : String,
                  val item5URL : String) {
    class Deserializer: ResponseDeserializable<Array<Match>> {
        override fun deserialize(content: String): Array<Match>? = Gson().fromJson(content, Array<Match>::class.java)
    }
}