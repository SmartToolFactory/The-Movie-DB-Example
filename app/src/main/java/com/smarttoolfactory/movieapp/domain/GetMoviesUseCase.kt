package com.smarttoolfactory.movieapp.domain

import com.smarttoolfactory.movieapp.data.MoviesRepository
import com.smarttoolfactory.movieapp.data.model.Movie
import io.reactivex.Observable
import javax.inject.Inject

/**
 * This UseCase is only responsible of retrieving data from DB or remote data source via [MoviesRepository]. Data returned
 * from db is filtered and might be queried via search function
 */
class GetMoviesUseCase @Inject constructor(private val repository: MoviesRepository) : BaseUseCase() {

    private var pagination = mutableListOf<Movie>()

    private var page: Int = 0

    fun getMovies(
        sortBy: String

    ): Observable<List<Movie>> {

        page++
        return repository
            .getMoviesSortedBy(page, sortBy)
            .flatMap {
                Observable.just(it.results)
            }.map {
                pagination.addAll(it)
                pagination
            }
    }


    override fun dispose() {

    }

}