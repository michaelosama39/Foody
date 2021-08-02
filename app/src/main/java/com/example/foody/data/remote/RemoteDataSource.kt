package com.example.foody.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiServices: ApiServices) :
    BaseRemoteDataSource() {
    suspend fun getRecipes() =
        getResult { apiServices.getAllRecipes("b07f7f9e95b548b29bdc5c7961b98cb7") }
}