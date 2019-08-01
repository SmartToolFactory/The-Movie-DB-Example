package com.smarttoolfactory.movieapp.api

import com.smarttoolfactory.movieapp.data.model.Movies
import retrofit2.Call
import retrofit2.http.GET

/**
 * Retrofit interface to
 */
interface MoviesApi {


    @GET("3/discover/movie")
    fun getMovies(): Call<Movies>

    companion object {

        const val BASE_URL = "https://api.themoviedb.org/"

        const val API_KEY = "114fe6670282f6a632638661e5e86dee"
    }


}
