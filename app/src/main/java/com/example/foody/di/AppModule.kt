package com.example.foody.di

import android.content.Context
import com.example.foody.data.local.AppDatabaseBuilder
import com.example.foody.data.local.Dao
import com.example.foody.data.local.LocalDataSource
import com.example.foody.data.remote.ApiServices
import com.example.foody.data.remote.AppNetworkBuilder
import com.example.foody.data.remote.RemoteDataSource
import com.example.foody.data.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppNetworkBuilder() : Retrofit = AppNetworkBuilder().provideRetrofitClient()

    @Singleton
    @Provides
    fun provideAppDataBaseBuilder(@ApplicationContext context: Context) =
        AppDatabaseBuilder.provideRoomDatabase(context)

    @Provides
    fun provideApiService(retrofit: Retrofit) :ApiServices = retrofit.create(ApiServices::class.java)

    @Provides
    fun provideDao(appDatabaseBuilder: AppDatabaseBuilder) = appDatabaseBuilder.getRecipes()

    @Provides
    fun provideRemoteDataSource(apiServices: ApiServices) = RemoteDataSource(apiServices)

    @Provides
    fun provideLocalDataSource(dao: Dao) = LocalDataSource(dao)

    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource , localDataSource: LocalDataSource) =
        Repository(remoteDataSource , localDataSource)
}