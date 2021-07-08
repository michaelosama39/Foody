package com.example.foody.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foody.view.home.recipesFragment.RecipesModelItem

@Dao
interface Dao {
    //Get
    @Query("select * from recipesList")
    fun getAllrecipes(): LiveData<List<RecipesModelItem>>

    //insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: ArrayList<RecipesModelItem>)

    //delete
    @Query("delete from recipesList WHERE id ==:recipeId")
    fun deleteById(recipeId: Int)
}