package com.smarttoolfactory.movieapp.di


import com.smarttoolfactory.movieapp.moviedetail.MovieDetailFragment
import com.smarttoolfactory.movieapp.movielist.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * FragmentContributorModule is used inside ActivityContributorModule
 * With @ContributesAndroidInjector(modules = FragmentContributorModule.class)
 * defines which module will be used to inject objects to declared fragments
 */
@Module
abstract class FragmentContributorModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment
}

