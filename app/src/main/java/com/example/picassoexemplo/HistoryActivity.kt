package com.example.picassoexemplo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_history.*
import org.json.JSONObject

class HistoryActivity  : AppCompatActivity() {

    val baseURL = "http://azurebruno.pythonanywhere.com/match_history/"

    var Matches = ArrayList<Match>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var URL = baseURL + intent.getStringExtra("SUMMONER") // erro de putExtra
        setContentView(R.layout.activity_history)
        val recyclerView = match_history

        //URL.httpGet().responseObject(Match.Deserializer()) { request, response, result ->
        URL.httpGet().responseString() { request, response, result ->
            //val (match, err) = result
            //Add to ArrayList
            // ERRO de get?
           // val matches = match.get
            //val convertedObject = Gson().fromJson(result, Match.class)
            val convertedObject = JSONObject(result.get())
            var match = convertedObject.getJSONArray("dados")
            println("teste" + convertedObject)
//            match?.forEach { teste ->
//               // Matches.add(match)
//                println("teste2"+match)
//            }
            var i = 0
            while ( i < match.length()){
                println("teste3"+match.getJSONObject(i))
                Matches.add(Fatiar(match.getJSONObject(i)))
                i++
            }

        }
        recyclerView.adapter = MatchListAdapter(Matches, this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

    }
}