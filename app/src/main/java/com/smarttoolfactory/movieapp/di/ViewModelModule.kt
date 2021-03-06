package com.smarttoolfactory.movieapp.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smarttoolfactory.movieapp.moviedetail.MovieDetailViewModel
import com.smarttoolfactory.movieapp.movielist.MovieListViewModel
import com.smarttoolfactory.movieapp.viewmodel.CustomViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *
 * This module is used for retrieving ViewModels using [CustomViewModelFactory], viewModels are put into map
 * via @IntoMap and @ViewModelKey annotations
 *
 * IntoMap creates a key-value pair to get relevant ViewModel. Key is the class name of ViewModel
 * and value is the ViewModel itself
 */
@Module
abstract class ViewModelModule {

    // Map MovieDetailViewModel to MovieDetailViewModel.class using this as a key
    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindMovieDetailViewModel (movieDetailViewModel: MovieDetailViewModel): ViewModel

    // Map MovieListViewModel to MovieListViewModel.class using this as a key
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindMovieListViewModel(movieListViewModel: MovieListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory
}
