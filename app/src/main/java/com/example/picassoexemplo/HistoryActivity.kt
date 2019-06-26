package com.example.picassoexemplo

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.ListView
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_list_item.*
import org.json.JSONObject

class HistoryActivity  : AppCompatActivity() {

    val baseURL = "http://azurebruno.pythonanywhere.com/match_history/"

    var Matches = ArrayList<Match>()

    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var URL = baseURL + intent.getStringExtra("SUMMONER") // erro de putExtra
        setContentView(R.layout.activity_history)
        val recyclerView = match_history
        listView = findViewById<ListView>(R.id.match_history)

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
                println("teste2"+Matches.size)
                i++
            }
        }
//        recyclerView.adapter = MatchListAdapter(Matches, this)
//        val layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager

        val adapter = MatchListAdapter(Matches, this)
        println("teste4")
        listView.adapter = adapter
//        while (Matches.size < 10){
//            refreshView()
//        }
//        when(Matches.size > 2) {
//            refreshView()
//        }

    }

    private fun refreshView(){
        findViewById<ConstraintLayout>(R.id.list_item).visibility = View.INVISIBLE
        findViewById<ConstraintLayout>(R.id.list_item).visibility = View.VISIBLE
    }
}