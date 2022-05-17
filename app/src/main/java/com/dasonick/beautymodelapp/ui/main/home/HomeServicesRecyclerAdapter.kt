package com.dasonick.beautymodelapp.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.ui.main.beauty_services.BeautyServicesRecyclerAdapter
import com.squareup.picasso.Picasso

class HomeServicesRecyclerAdapter(
    private val beautyServices: List<BeautyService>,
    private val navController: NavController
) :
    RecyclerView.Adapter<HomeServicesRecyclerAdapter.MyViewHolder>() {

    private lateinit var context: Context

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.beauty_services_item_name)
        val priceTextView: TextView = itemView.findViewById(R.id.beauty_services_item_price)
        val imageView: ImageView = itemView.findViewById(R.id.beauty_services_item_image)
        val layout: LinearLayout = itemView.findViewById(R.id.beauty_services_item_layout)
    }

    override fun getItemCount() = beautyServices.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.service_item, parent, false)
        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTextView.text = beautyServices[position].name
        holder.priceTextView.text = "${beautyServices[position].price}₽"
        holder.layout.setOnClickListener {
            //navController.navigate(R.id.action_categoriesFragment_to_beautyServicesFragment)
        }
        Picasso.with(context)
            .load(beautyServices[position].imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_baseline_home_24)
            .into(holder.imageView);
    }
}