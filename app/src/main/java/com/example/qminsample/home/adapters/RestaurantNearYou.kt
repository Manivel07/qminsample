package com.example.qminsample.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qminsample.databinding.ItemRestaurantNearYouBinding
import com.example.qminsample.dataclass.RestaurantDataClass

class RestaurantNearYou(
    private var restaurantList: ArrayList<RestaurantDataClass>
) : RecyclerView.Adapter<RestaurantNearYou.ViewHolder>() {
    class ViewHolder(private val view: ItemRestaurantNearYouBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(data: RestaurantDataClass) {
            view.tvHotelName.text = data.ResTitle
            view.rvRestaurants.adapter = RestaurantCategory(data)
            if (data.hotelName.size>=5){
                view.clBottomArrow.visibility=View.VISIBLE
            }else{
                view.clBottomArrow.visibility=View.GONE
            }
            view.clBottomArrow.setOnClickListener {

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val resData =
            ItemRestaurantNearYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(resData)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }
}