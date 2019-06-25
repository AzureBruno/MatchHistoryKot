package com.example.picassoexemplo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener{
            val summonerName = edt_summonerName.text.toString()
            val intent = Intent(applicationContext, HistoryActivity::class.java)
            intent.putExtra("SUMMONER", summonerName)
            startActivity(intent)
        }
    }
//    private fun proxActivity(Activity : AppCompatActivity, extra : String) {
//        val intent = Intent(applicationContext, Activity::class.java)
//        intent.putExtra(extra, "summoner")
//        startActivity(intent)
//    }
}
