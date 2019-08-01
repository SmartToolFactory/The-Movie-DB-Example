package com.smarttoolfactory.movieapp.data

import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.data.model.Movies
import io.reactivex.Observable
import javax.inject.Inject

/**
 * [MoviesRepositoryImpl] is concrete implementation of Repository pattern which acts as a Persistence
 * layer with local, remote and cached providers.
 */
class MoviesRepositoryImpl @Inject constructor(val moviesDataSource: MoviesDataSource) : MoviesRepository {

    override fun getMovies(page: Int): Observable<Movies> {
       return moviesDataSource.getMovies(page)
    }

    override fun getMoviesSortedBy( page: Int,sortBy: String): Observable<Movies> {
        return moviesDataSource.getMoviesSortedBy( page, sortBy)
    }

    override fun getMovies(queryMap: Map<String, String>): Observable<Movies> {
        return moviesDataSource.getMovies(queryMap)
    }


    // TODO Add caching mechanism
    private val cache: Map<String, List<Movie>> = LinkedHashMap()


}