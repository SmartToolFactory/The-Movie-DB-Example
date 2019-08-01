package com.smarttoolfactory.movieapp.api

import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface to get movies list from remote source which is The MovieDB in this case
 */
interface MoviesApi {


    @GET("3/discover/movie")
    fun getMovies(@Query("api_key") apiKey: String): Observable<Movies>

    @GET("3/discover/movie")
    fun getMoviesSortedBy(@Query("api_key") apiKey: String, @Query("sort_by") sortBy: String): Observable<Movies>

    companion object {

        const val BASE_URL = "https://api.themoviedb.org/"

        const val API_KEY = "114fe6670282f6a632638661e5e86dee"
    }


}
