package com.smarttoolfactory.movieapp.data.source.remote

import com.smarttoolfactory.movieapp.api.MoviesApi
import com.smarttoolfactory.movieapp.data.MoviesDataSource
import javax.inject.Inject


class RemoteMoviesDataSource @Inject constructor(val moviesApi: MoviesApi) : MoviesDataSource {


}