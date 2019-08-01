package com.smarttoolfactory.movieapp.data

import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable

/**
 * [MoviesRepository] interface is used for implementing Repository pattern which provides
 * persistence layer that consists of Remote and Local data sources.
 */
interface MoviesRepository {

    fun getMovies(page: Int): Observable<Movies>

    fun getMoviesSortedBy( page: Int, sortBy: String): Observable<Movies>

    fun getMovies(queryMap : Map<String, String>): Observable<Movies>

}