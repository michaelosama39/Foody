package com.example.foody.view.home.recipesFragment
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class RecipesModel(val RecipesModelItem : ArrayList<RecipesModelItem>)

const val RECIPE_ID = 0
@Entity(tableName = "recipesList")
data class RecipesModelItem(
    val image: String,
    val imageType: String,
    val likes: Int,
    val missedIngredientCount: Int,
//    val missedIngredients: List<MissedIngredient>,
    val title: String,
//    val unusedIngredients: List<Any>,
    val usedIngredientCount: Int,
//    val usedIngredients: List<UsedIngredient>
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = RECIPE_ID
}


data class MissedIngredient(
    val aisle: String,
    val amount: Double,
    val id: Int,
    val image: String,
//    val meta: List<Any>,
//    val metaInformation: List<Any>,
    val name: String,
    val original: String,
    val originalName: String,
    val originalString: String,
    val unit: String,
    val unitLong: String,
    val unitShort: String
)

data class UsedIngredient(
    val aisle: String,
    val amount: Double,
    val id: Int,
    val image: String,
//    val meta: List<Any>,
//    val metaInformation: List<Any>,
    val name: String,
    val original: String,
    val originalName: String,
    val originalString: String,
    val unit: String,
    val unitLong: String,
    val unitShort: String
)