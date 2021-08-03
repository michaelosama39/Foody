package com.example.foody

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.foody.view.home.favoritesFragment.FavoritesFragment
import com.example.foody.view.home.foodJokeFragment.FoodJokeFragment
import com.example.foody.view.home.recipesFragment.RecipesFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//
//        val navController = findNavController(R.id.fragment_container)
//        bottom_navigation.setupwithNavController(navController)

        val fragmentRecipes = RecipesFragment()
        val fragmentFavorites = FavoritesFragment()
        val fragmentFoodJoke = FoodJokeFragment()

        bottom_navigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.recipes_nav -> {
                    makeCurrentFragment(fragmentRecipes)
                    true
                }
                R.id.favorites_nav -> {
                    makeCurrentFragment(fragmentFavorites)
                    true
                }
                R.id.food_joke_nav -> {
                    makeCurrentFragment(fragmentFoodJoke)
                    true
                }
            }
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment).commit()
            Toast.makeText(applicationContext, "okk", Toast.LENGTH_LONG).show()
        }
    }
}