package com.qbo.appkea2retrofitkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qbo.appkea2retrofitkotlin.R

import com.qbo.appkea2retrofitkotlin.model.Album

class AlbumAdapter (private val lstalbum : List<Album>)
    : RecyclerView.Adapter<AlbumAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tvid: TextView = itemView.findViewById(R.id.tvid)
        val tvtitulo: TextView = itemView.findViewById(R.id.tvtitulo)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(R.layout.item_album,
                parent, false)
        )
    }
    override fun onBindViewHolder(holder: AlbumAdapter.ViewHolder, position: Int) {
        val item = lstalbum[position]
        holder.tvid.text = item.id.toString()
        holder.tvtitulo.text = item.title
    }
    override fun getItemCount(): Int {
        return lstalbum.size
    }


}