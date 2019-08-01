package com.smarttoolfactory.movieapp.di


import com.smarttoolfactory.movieapp.api.MoviesApi
import com.smarttoolfactory.movieapp.data.MoviesDataSource
import com.smarttoolfactory.movieapp.data.MoviesRepository
import com.smarttoolfactory.movieapp.data.MoviesRepositoryImpl
import com.smarttoolfactory.movieapp.data.source.remote.RemoteMoviesDataSource

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {

    /*
       *** REST Api Injections ***
    */

    @Singleton
    @Provides
    fun provideMoviesApi(): MoviesApi {
        return Retrofit.Builder()
            .baseUrl(MoviesApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MoviesApi::class.java)
    }


    @Singleton
    @Provides
    fun providesMoviesDataSource(moviesApi: MoviesApi): MoviesDataSource {
        return RemoteMoviesDataSource(moviesApi)
    }


    /*
        *** Database Injections ***
     */




    @Singleton
    @Provides
    fun provideRepository(moviesDataSource: MoviesDataSource): MoviesRepository {
        return MoviesRepositoryImpl(moviesDataSource)
    }
}