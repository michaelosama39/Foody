package com.example.foody.view.home.recipesFragment
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Recipes(
    val number: Int,
    val offset: Int,
    val results: ArrayList<Result>,
    val totalResults: Int
)

const val RECIPE_ID = 0

@Entity(tableName = "recipesList")
data class Result(
    val image: String,
    val imageType: String,
    val title: String
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = RECIPE_ID
}