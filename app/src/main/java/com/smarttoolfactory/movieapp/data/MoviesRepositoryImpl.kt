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
    override fun getMovies(): Observable<Movies> {
       return moviesDataSource.getMovies()
    }

    override fun getMoviesSortedBy(sortBy: String): Observable<Movies> {
        return moviesDataSource.getMoviesSortedBy(sortBy)
    }


    // TODO Add caching mechanism
    private val cache: Map<String, List<Movie>> = LinkedHashMap()


}