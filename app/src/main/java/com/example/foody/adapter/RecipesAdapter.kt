package com.example.foody.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foody.R
import com.example.foody.view.home.recipesFragment.RecipesModelItem

class RecipesAdapter(val RecipesItemListener: RecipeItemListener ) : RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {

    var recipesDataList : ArrayList<RecipesModelItem> = arrayListOf()

    fun setData(recipesDataList: ArrayList<RecipesModelItem>){
        this.recipesDataList = recipesDataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe , parent , false )
        return RecipesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return recipesDataList?.size!!
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.bindData(recipesDataList[position])
        recipesDataList?.get(position)?.let { it1 -> RecipesItemListener.onRecipesItemClicked(it1) }
    }

    interface RecipeItemListener{
        fun onRecipesItemClicked(recipesModelItem: RecipesModelItem)
    }

    inner class RecipesViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val recipes_title: TextView = view.findViewById(R.id.recipes_title)
        val recipes_body: TextView = view.findViewById(R.id.recipes_body)
        val servingsTV: TextView = view.findViewById(R.id.servingsTV)
        val readyInMinutesTV: TextView = view.findViewById(R.id.readyInMinutesTV)
        val recipes_img: ImageView = view.findViewById(R.id.recipes_img)

        fun bindData(recipesDataList : RecipesModelItem) {
            recipes_title.text = recipesDataList.title
            Glide.with(recipes_img.context).load(recipesDataList.image).into(recipes_img)
        }
    }
}