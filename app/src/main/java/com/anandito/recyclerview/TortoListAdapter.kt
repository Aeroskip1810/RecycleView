package com.anandito.recyclerview

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class TortoListAdapter(private val torto: ArrayList<Torto>): RecyclerView.Adapter<TortoListAdapter.TortoViewHolder>() {

    class TortoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val ivPhoto: ImageView = itemView.findViewById(R.id.ivPhoto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TortoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.torto_list_item, parent, false)
        return TortoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TortoViewHolder, position: Int) {
        val (name, description, photo) = torto[position]
        holder  .tvName.text = name
        holder  .tvDescription.text = description
        holder  .ivPhoto.setImageResource(photo)
    }

    private fun torto(position: Int) {

    }

    override fun getItemCount(): Int {
        return torto.size
    }
}