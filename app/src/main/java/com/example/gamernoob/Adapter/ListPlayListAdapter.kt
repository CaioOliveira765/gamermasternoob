package com.example.gamemasternoob.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gamernoob.R
import kotlinx.android.synthetic.main.card_playlist_item.view.*

class ListPlayListAdapter : RecyclerView.Adapter<ListPlayListViewHolder>() {

    val videoTitles = listOf("123")

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListPlayListViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellFor = layoutInflater.inflate(R.layout.card_playlist_item, parent, false)
        return ListPlayListViewHolder(cellFor)
    }

    override fun getItemCount(): Int {
        return videoTitles.size
    }

    override fun onBindViewHolder(holder: ListPlayListViewHolder?, position: Int) {
        val videoTitlle = videoTitles.get(position)
        holder?.view?.textView_Titlle?.text =  videoTitlle
    }

}

class ListPlayListViewHolder(val view : View) : RecyclerView.ViewHolder(view){

}