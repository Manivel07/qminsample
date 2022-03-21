package com.example.qminsample.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qminsample.R

class SpotLightAdapter (private var imageBg:Array<Int>,private var festivalName:Array<String>):RecyclerView.Adapter<SpotLightAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var festivalImage:ImageView=view.findViewById(R.id.ivSpecial)
        var fesName:TextView=view.findViewById(R.id.tvChirstmas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val spotData=
            LayoutInflater.from(parent.context).inflate(R.layout.item_spotlight,parent,false)
        return SpotLightAdapter.ViewHolder(spotData)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.festivalImage.setImageResource(imageBg[position])
        holder.fesName.text=festivalName[position]
    }

    override fun getItemCount(): Int {
        return imageBg.size
    }
}