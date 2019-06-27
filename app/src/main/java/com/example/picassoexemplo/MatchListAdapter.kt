package com.example.picassoexemplo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list_item.view.*

class MatchListAdapter(private val matches: List<Match>, private val context: Context) :
    Adapter<MatchListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_list_item, p0, false)!!
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val match = matches[p1]
        p0?.let {
            it.bindView(match)
        }
    }


    class ViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
        val context = context
        fun bindView(match: Match) {

            val imageChampion = itemView.image_champion
            val textWin = itemView.text_win
            val textScore = itemView.text_score
            val textQueue = itemView.text_queue
            val imgItem0 = itemView.img_item0
            val imgItem1 = itemView.img_item1
            val imgItem2 = itemView.img_item2
            val imgItem3 = itemView.img_item3
            val imgItem4 = itemView.img_item4
            val imgItem5 = itemView.img_item5

            updateWithURL(match.championPNG, imageChampion)
            textWin.text = match.win.capitalize()
            textQueue.text = match.queue
            defineBackground(match)
            textScore.text = "KDA: ${match.kills}/${match.deaths}/${match.assists} CS: ${match.cs}"
            /*
                Load item images
                 */
            updateWithURL(match.item0URL, imgItem0)
            updateWithURL(match.item1URL, imgItem1)
            updateWithURL(match.item2URL, imgItem2)
            updateWithURL(match.item3URL, imgItem3)
            updateWithURL(match.item4URL, imgItem4)
            updateWithURL(match.item5URL, imgItem5)
        }

        private fun defineBackground(match: Match) {
            if (match.win == "victory") {
                itemView.setBackgroundColor(context.resources.getColor(R.color.win))
            } else {
                itemView.setBackgroundColor(context.resources.getColor(R.color.lose))
            }
        }

        private fun updateWithURL(url: String, imageView: ImageView) {
            Picasso.get().load(url).placeholder(R.mipmap.empty_item).into(imageView)
        }
    }

}