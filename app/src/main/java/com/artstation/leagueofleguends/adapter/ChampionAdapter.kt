package com.artstation.leagueofleguends.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.artstation.leagueofleguends.DetailChampionActivity
import com.artstation.leagueofleguends.R
import com.artstation.leagueofleguends.data.Champion
import com.bumptech.glide.Glide

class ChampionAdapter(private val mList: List<Champion>) :
    RecyclerView.Adapter<ChampionAdapter.ViewHolder>() {
    var onclick: ((Champion) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        Glide.with(holder.imageView)
            .load(item.image)
            .into(holder.imageView)
        holder.textView.text = item.name
        holder.container.setOnClickListener {
            val i = Intent(holder.imageView.context, DetailChampionActivity::class.java)
            i.putExtra("champ", item)
            holder.imageView.context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.name)
        val container: ConstraintLayout = itemView.findViewById(R.id.container)
    }
}