package com.example.picassoexemplo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list_item.view.*

class MatchListAdapter(private val matches: List<Match>,
                       private val context: Context
) : Adapter<MatchListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val match = matches[position]
        holder?.let {
            it.bindView(match)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(match: Match) {

            val imageChampion = itemView.image_champion
            val textQueue = itemView.text_queue
            val textScore = itemView.text_score
            val imgItem0 = itemView.img_item0
            val imgItem1 = itemView.img_item1
            val imgItem2 = itemView.img_item2
            val imgItem3 = itemView.img_item3
            val imgItem4 = itemView.img_item4
            val imgItem5 = itemView.img_item5

            Picasso
                .get()
                .load(match.championPNG)
                .into(imageChampion)
            textQueue.text = match.win
            textScore.text = match.kills.toString() + "/" + match.deaths.toString() + "/" + match.assists.toString()
            /*
                Load item images
                 */
            Picasso
                .get()
                .load(match.item0URL)
                .into(imgItem0)
            Picasso
                .get()
                .load(match.item1URL)
                .into(imgItem1)
            Picasso
                .get()
                .load(match.item2URL)
                .into(imgItem2)
            Picasso
                .get()
                .load(match.item3URL)
                .into(imgItem3)
            Picasso
                .get()
                .load(match.item4URL)
                .into(imgItem4)
            Picasso
                .get()
                .load(match.item5URL)
                .into(imgItem5)
        }

    }
}
