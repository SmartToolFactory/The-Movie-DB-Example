package com.smarttoolfactory.movieapp.data.source.remote

import com.smarttoolfactory.movieapp.api.MoviesApi
import com.smarttoolfactory.movieapp.data.MoviesDataSource
import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable
import javax.inject.Inject


class RemoteMoviesDataSource @Inject constructor(val moviesApi: MoviesApi) : MoviesDataSource {

    override fun getMovies(page: Int): Observable<Movies> {
        println("RemoteMoviesDataSource getMovies() page $page")
        return moviesApi.getMovies(MoviesApi.API_KEY, page)
    }

    override fun getMoviesSortedBy(page: Int, sortBy: String): Observable<Movies> {
        return moviesApi.getMoviesSortedBy(MoviesApi.API_KEY, page, sortBy)
    }

    override fun getMovies(queryMap: Map<String, String>): Observable<Movies> {
        return moviesApi.getMovies(queryMap)
    }


}