package com.smarttoolfactory.movieapp.domain

import com.smarttoolfactory.movieapp.data.MoviesRepository
import javax.inject.Inject

/**
 * This UseCase is only responsible of retrieving data from DB or remote data source via [MoviesRepository]. Data returned
 * from db is filtered and might be queried via search function
 */
class GetMoviesCase @Inject constructor(private val repository: MoviesRepository) : BaseUseCase() {

    override fun dispose() {

    }

}