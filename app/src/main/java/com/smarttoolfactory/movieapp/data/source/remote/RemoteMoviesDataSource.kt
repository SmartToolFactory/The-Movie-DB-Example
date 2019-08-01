package com.smarttoolfactory.movieapp.data.source.remote

import com.smarttoolfactory.movieapp.api.MoviesApi
import com.smarttoolfactory.movieapp.data.MoviesDataSource
import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable
import javax.inject.Inject


class RemoteMoviesDataSource @Inject constructor(val moviesApi: MoviesApi) : MoviesDataSource {
    override fun getMovies(): Observable<Movies> {
        return moviesApi.getMovies(MoviesApi.API_KEY)
    }

    override fun getMoviesSortedBy(sortBy: String): Observable<Movies> {
        return moviesApi.getMoviesSortedBy(MoviesApi.API_KEY, sortBy)
    }

}