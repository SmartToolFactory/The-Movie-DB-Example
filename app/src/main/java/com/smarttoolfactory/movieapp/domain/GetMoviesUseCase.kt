package com.smarttoolfactory.movieapp.domain

import com.smarttoolfactory.movieapp.data.MoviesRepository
import com.smarttoolfactory.movieapp.data.model.Movie
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * This UseCase is only responsible of retrieving data from DB or remote data source via [MoviesRepository]. Data returned
 * from db is filtered and might be queried via search function
 */
class GetMoviesUseCase @Inject constructor(private val repository: MoviesRepository) : BaseUseCase() {

    private var page: Int = 0

    fun getMovies(
        movieList: MutableList<Movie>,
        sortBy: String,
        pagination: BehaviorSubject<Int>
    ): Observable<List<Movie>> {

        page++
        return repository.getMoviesSortedBy(page, sortBy).map {
            it.results
        }
    }


    override fun dispose() {

    }

}