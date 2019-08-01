package com.smarttoolfactory.movieapp.data.source.local

import com.smarttoolfactory.movieapp.data.MoviesDataSource
import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This is the local data provider for movies. This can also be SSOT
 */
//@Singleton
//class LocalMoviesDataSource @Inject constructor(val moviesDao: MoviesDao) : MoviesDataSource {
//    override fun getMovies(page: Int): Observable<Movies> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//
//}