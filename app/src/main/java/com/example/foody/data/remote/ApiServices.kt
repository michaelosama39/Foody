package com.example.foody.data.remote

import com.example.foody.view.home.recipesFragment.RecipesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("complexSearch")
    suspend fun getAllRecipes(
        @Query("apiKey") apiKey: String,
        @Query("includeNutrition") includeNutrition: Boolean
    ): Response<RecipesModel>
}