package com.example.picassoexemplo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list_item.view.*

class MatchListAdapter(private val matches: List<Match>, private val context: Context) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return matches.size
    }

    //2
    override fun getItem(position: Int): Any {
        return matches[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.activity_list_item, parent, false)

        val imageChampion = rowView.findViewById(R.id.image_champion) as ImageView
        val textQueue = rowView.findViewById(R.id.text_queue) as TextView
        val textScore = rowView.findViewById(R.id.text_score) as TextView
        val imgItem0 = rowView.findViewById(R.id.img_item0) as ImageView
        val imgItem1 = rowView.findViewById(R.id.img_item1) as ImageView
        val imgItem2 = rowView.findViewById(R.id.img_item2) as ImageView
        val imgItem3 = rowView.findViewById(R.id.img_item3) as ImageView
        val imgItem4 = rowView.findViewById(R.id.img_item4) as ImageView
        val imgItem5 = rowView.findViewById(R.id.img_item5) as ImageView


        val match = getItem(position) as Match

        Picasso.get().load(match.championPNG).placeholder(R.mipmap.ic_launcher).into(imageChampion)
        textQueue.text = match.win
        textScore.text = "${match.kills}/${match.deaths}/${match.assists}"
        Picasso.get().load(match.item0URL).placeholder(R.mipmap.ic_launcher).into(imgItem0)
        Picasso.get().load(match.item1URL).placeholder(R.mipmap.ic_launcher).into(imgItem1)
        Picasso.get().load(match.item2URL).placeholder(R.mipmap.ic_launcher).into(imgItem2)
        Picasso.get().load(match.item3URL).placeholder(R.mipmap.ic_launcher).into(imgItem3)
        Picasso.get().load(match.item4URL).placeholder(R.mipmap.ic_launcher).into(imgItem4)
        Picasso.get().load(match.item5URL).placeholder(R.mipmap.ic_launcher).into(imgItem5)

        return rowView
    }






//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
//        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_list_item, p0, false)!!
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return matches.size
//    }
//
//    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
//        val match = matches[p1]
//        p0?.let {
//            it.bindView(match)
//        }
//    }


//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bindView(match: Match) {
//
//            val imageChampion = itemView.image_champion
//            val textQueue = itemView.text_queue
//            val textScore = itemView.text_score
//            val imgItem0 = itemView.img_item0
//            val imgItem1 = itemView.img_item1
//            val imgItem2 = itemView.img_item2
//            val imgItem3 = itemView.img_item3
//            val imgItem4 = itemView.img_item4
//            val imgItem5 = itemView.img_item5
//
//            Picasso
//                .get()
//                .load(match.championPNG)
//                .into(imageChampion)
//            textQueue.text = match.win
//            textScore.text = "${match.kills}/${match.deaths}/${match.assists}"
//            /*
//                Load item images
//                 */
//            Picasso
//                .get()
//                .load(match.item0URL)
//                .into(imgItem0)
//            Picasso
//                .get()
//                .load(match.item1URL)
//                .into(imgItem1)
//            Picasso
//                .get()
//                .load(match.item2URL)
//                .into(imgItem2)
//            Picasso
//                .get()
//                .load(match.item3URL)
//                .into(imgItem3)
//            Picasso
//                .get()
//                .load(match.item4URL)
//                .into(imgItem4)
//            Picasso
//                .get()
//                .load(match.item5URL)
//                .into(imgItem5)
//        }
//
//    }
}
