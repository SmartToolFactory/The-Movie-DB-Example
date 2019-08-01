package com.smarttoolfactory.movieapp.di


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.smarttoolfactory.movieapp.api.MoviesApi
import com.smarttoolfactory.movieapp.constant.Constants
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
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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


    /*
        *** Repository Injections ***
     */

    @Singleton
    @Provides
    fun provideRepository(moviesDataSource: MoviesDataSource): MoviesRepository {
        return MoviesRepositoryImpl(moviesDataSource)
    }
}
