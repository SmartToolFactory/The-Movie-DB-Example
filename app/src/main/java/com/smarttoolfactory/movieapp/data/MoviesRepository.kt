package com.smarttoolfactory.movieapp.data

import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable

/**
 * [MoviesRepository] interface is used for implementing Repository pattern which provides
 * persistence layer that consists of Remote and Local data sources.
 */
interface MoviesRepository {

    fun getMovies(): Observable<Movies>

    fun getMoviesSortedBy( sortBy: String): Observable<Movies>

}