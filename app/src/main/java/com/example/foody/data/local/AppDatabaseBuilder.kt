package com.example.foody.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foody.view.home.recipesFragment.Result


@Database(entities = [Result::class], version = 1, exportSchema = false)
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