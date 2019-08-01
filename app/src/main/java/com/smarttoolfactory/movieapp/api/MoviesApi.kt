package com.smarttoolfactory.movieapp.api

import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * Retrofit interface to get movies list from remote source which is The MovieDB in this case
 */
interface MoviesApi {


    /**
     * Gets movies returned by service on specified page
     */
    @GET("3/discover/movie")
    fun getMovies(@Query("api_key") apiKey: String, @Query("page") page: Int): Observable<Movies>

    /**
     * Gets movies returned by service on specified page by sorting by the given criteria
     */
    @GET("3/discover/movie")
    fun getMoviesSortedBy(@Query("api_key") apiKey: String, @Query("page") page: Int, @Query("sort_by") sortBy: String): Observable<Movies>


    /**
     * Gets movies returned by service and sends parameters as key, value pair
     */
    @GET("3/discover/movie")
    fun getMovies(@QueryMap queryMap: Map<String, String>): Observable<Movies>





}
