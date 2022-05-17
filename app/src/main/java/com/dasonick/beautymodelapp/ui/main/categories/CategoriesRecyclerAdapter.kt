package com.dasonick.beautymodelapp.ui.main.categories

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.base.Category
import com.squareup.picasso.Picasso

class CategoriesRecyclerAdapter(
    private val categories: List<Category>,
    private val navController: NavController
) :
    RecyclerView.Adapter<CategoriesRecyclerAdapter.MyViewHolder>() {

    private lateinit var context: Context

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.category_item_name)
        val imageView: ImageView = itemView.findViewById(R.id.category_item_image)
        val layout: LinearLayout = itemView.findViewById(R.id.category_item_layout)
    }

    override fun getItemCount() = categories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false)
        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTextView.text = categories[position].name
        holder.layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("category", categories[position].id)
            navController.navigate(
                R.id.action_categoriesFragment_to_beautyServicesFragment3,
                bundle
            )
        }
        Picasso.with(context)
            .load(categories[position].imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_baseline_home_24)
            .into(holder.imageView);
    }
}