package com.example.foody.data.repo

import com.example.foody.data.local.LocalDataSource
import com.example.foody.data.remote.RemoteDataSource
import com.example.foody.utilts.performGetOperation
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource
) {

    fun getRecipeList() = performGetOperation(
        dataBaseQuery = { localDataSource.getRecipes() },
        netWorkCall = { remoteDataSource.getRecipes() },
        saveCallResult = { localDataSource.insertRecipes(it.results) })

}