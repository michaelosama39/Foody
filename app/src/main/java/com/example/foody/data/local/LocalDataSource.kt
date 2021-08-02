package com.example.foody.data.local

import com.example.foody.view.home.recipesFragment.Result
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: Dao) {
    fun getRecipes() =dao.getAllrecipes()
    fun insertRecipes(recipesModelItem: ArrayList<Result>) =dao.insert(recipesModelItem)
}