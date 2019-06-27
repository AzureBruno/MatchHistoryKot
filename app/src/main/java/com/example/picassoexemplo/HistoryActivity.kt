package com.example.picassoexemplo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.activity_history.*
import org.json.JSONObject

class HistoryActivity : AppCompatActivity() {

    val baseURL = "http://azurebruno.pythonanywhere.com/match_history/"

    var Matches = ArrayList<Match>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var URL = baseURL + intent.getStringExtra("SUMMONER")
        setContentView(R.layout.activity_history)
        val recyclerView = match_history
        val loading = loading

        URL.httpGet().responseString() { request, response, result ->
            val convertedObject = JSONObject(result.get())
            var match = convertedObject.getJSONArray("dados")
            var i = 0
            while (i < match.length()) {
                Matches.add(Fatiar(match.getJSONObject(i)))
                i++
            }
            if (i >= match.length()) {
                loading.visibility = View.GONE
                recyclerView.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }

        }
        recyclerView.adapter = MatchListAdapter(Matches, this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

    }
}