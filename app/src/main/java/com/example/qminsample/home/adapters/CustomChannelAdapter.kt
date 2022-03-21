package com.example.qminsample.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qminsample.R

class CustomChannelAdapter ( private var context:Context,private var celebrationtext:Array<String>,private var celebrationDesc:Array<String>):RecyclerView.Adapter<CustomChannelAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        var celebrationtext:TextView=view.findViewById(R.id.tvChannelName)
        var celebrationDesc:TextView=view.findViewById(R.id.tvDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val customdata=
            LayoutInflater.from(context).inflate(R.layout.item_custom_channel,parent,false)
        return ViewHolder(customdata)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.celebrationtext.text=celebrationtext[position]
        holder.celebrationDesc.text=celebrationDesc[position]
    }

    override fun getItemCount(): Int {
        return celebrationtext.size
    }
}