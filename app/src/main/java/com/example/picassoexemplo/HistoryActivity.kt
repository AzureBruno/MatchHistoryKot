package com.example.picassoexemplo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import sun.util.locale.provider.LocaleProviderAdapter.getAdapter
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager

class HistoryActivity (summonerName : String) : AppCompatActivity() {

    var tvGetResponse: TextView? = null
    var tvPostResponse: TextView? = null
    var progress: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewsAndWidgets()
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        FuelManager.instance.basePath = "http://azurebruno.pythonanywhere.com/match_history/"
}

    private fun initViewsAndWidgets() {
        tvGetResponse = findViewById(R.id.tvGetResponse)
        tvPostResponse = findViewById(R.id.tvPostResponse)
        progress = ProgressDialog(this)
        progress!!.setTitle("Kotlin Fuel Http Sample")
        progress!!.setMessage("Loading...")
    }

    fun httpGetJson(view: View) {
        try {
            progress!!.show()
            Fuel.get("summonerName").responseJson { request, response, result ->
                tvGetResponse!!.text = result.get().content
            }
        } catch (e: Exception) {
            tvGetResponse!!.text = e.message
        } finally {
            progress!!.dismiss()
        }
    }
}