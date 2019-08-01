package com.smarttoolfactory.movieapp.data

import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable

interface MoviesDataSource {

    fun getMovies(): Observable<Movies>

    fun getMoviesSortedBy(sortBy: String): Observable<Movies>

}