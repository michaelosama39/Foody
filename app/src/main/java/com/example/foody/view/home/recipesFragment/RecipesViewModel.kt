package com.example.foody.view.home.recipesFragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.foody.data.repo.Repository

class RecipesViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel()  {
    val recipesList = repository.getRecipeList()
}