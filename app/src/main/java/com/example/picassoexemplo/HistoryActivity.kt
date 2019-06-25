package com.example.picassoexemplo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity  : AppCompatActivity() {

    val baseURL = "http://azurebruno.pythonanywhere.com/match_history/azurebruno"
    var URL = baseURL //+ intent.getSerializableExtra("SUMMONER") // erro de putExtra
    var Matches = ArrayList<Match>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val recyclerView = match_history

        URL.httpGet().responseObject(Match.Deserializer()) { request, response, result ->
            val (match, err) = result
            //Add to ArrayList
            // ERRO de get?
            println("teste" + result)
            match?.forEach { match ->
                Matches.add(match)
                println("teste2"+match)
            }
            println("teste3"+Matches)
        }
        recyclerView.adapter = MatchListAdapter(Matches, this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }
}