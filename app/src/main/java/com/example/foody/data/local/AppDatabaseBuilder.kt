package com.example.foody.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foody.view.home.recipesFragment.RecipesModel
import com.example.foody.view.home.recipesFragment.RecipesModelItem


@Database(entities = [RecipesModelItem::class], version = 1, exportSchema = false)
abstract class AppDatabaseBuilder : RoomDatabase() {

    abstract fun getRecipes(): Dao

    companion object {
        private var instance: AppDatabaseBuilder? = null

        fun provideRoomDatabase(appContext: Context): AppDatabaseBuilder =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(appContext).also { instance = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabaseBuilder::class.java, "recipesAppDB")
                .fallbackToDestructiveMigration()
                .build()
    }

}