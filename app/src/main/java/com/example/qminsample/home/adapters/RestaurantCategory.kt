package com.example.qminsample.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qminsample.R
import com.example.qminsample.databinding.ItemRestaurantCategoryBinding
import com.example.qminsample.dataclass.RestaurantDataClass

class RestaurantCategory (private var restCategoryName:RestaurantDataClass):RecyclerView.Adapter<RestaurantCategory.ViewHolder>() {
   class ViewHolder(private val view:ItemRestaurantCategoryBinding):RecyclerView.ViewHolder(view.root){
       fun bind(data:RestaurantDataClass,position: Int){
           view.tvRestaurantName.text=data.RestaurantName[position]
           view.tvSpecial.text=data.hotelName[position]
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val category=ItemRestaurantCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(category)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(restCategoryName,position)
    }

    override fun getItemCount(): Int {
        return restCategoryName.RestaurantName.size
    }

}