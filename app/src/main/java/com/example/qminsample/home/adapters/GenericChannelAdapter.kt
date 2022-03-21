package com.example.qminsample.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qminsample.databinding.ItemGenericChannelsBinding
import com.example.qminsample.dataclass.GenericData

class GenericChannelAdapter(var context: Context, var genricChannel: List<GenericData>) :
    RecyclerView.Adapter<GenericChannelAdapter.ViewHolder>() {
    class ViewHolder(private val view: ItemGenericChannelsBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(data: GenericData) {
            view.tvEventName.text = data.name
            view.tvDescription.text = data.body_hero_text
            Glide.with(view.root.context).load(data.image_url).centerCrop().into(view.ivFood)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val genericdata =
            ItemGenericChannelsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(genericdata)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genricChannel[position])
    }

    override fun getItemCount(): Int {
        return genricChannel.size
    }
}