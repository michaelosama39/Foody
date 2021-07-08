package com.example.foody.data.local

import com.example.foody.view.home.recipesFragment.RecipesModelItem
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: Dao) {
    fun getRecipes() =dao.getAllrecipes()
    fun insertRecipes(recipesModelItem: ArrayList<RecipesModelItem>) =dao.insert(recipesModelItem)
}