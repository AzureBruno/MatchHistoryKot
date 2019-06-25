package com.example.picassoexemplo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener{
            val summonerName = edt_summonerName.text.toString()
            nextActivity(HistoryActivity(), summonerName)
        }
    }
    fun nextActivity(Activity : AppCompatActivity, EXTRA : String) {
        val intent = Intent(applicationContext, Activity::class.java)
        intent.putExtra("Summoner",EXTRA)
        startActivity(intent)
    }
}
