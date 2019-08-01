package com.smarttoolfactory.movieapp.data

import com.smarttoolfactory.movieapp.data.model.Movie
import javax.inject.Inject

/**
 * [MoviesRepositoryImpl] is concrete implementation of Repository pattern which acts as a Persistence
 * layer with local, remote and cached providers.
 */
class MoviesRepositoryImpl @Inject constructor(val moviesDataSource: MoviesDataSource) : MoviesRepository {


    // TODO Add caching mechanism
    private val cache: Map<String, List<Movie>> = LinkedHashMap()


}