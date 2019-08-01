package com.smarttoolfactory.movieapp.data

import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable

interface MoviesDataSource {

    fun getMovies(page: Int): Observable<Movies>

    fun getMoviesSortedBy( page: Int, sortBy: String): Observable<Movies>

    fun getMovies(queryMap : Map<String, String>): Observable<Movies>

}