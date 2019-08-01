package com.smarttoolfactory.movieapp.di


import com.smarttoolfactory.movieapp.moviedetail.MovieDetailFragment
import com.smarttoolfactory.movieapp.movielist.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * DetailFragmentContributorModule is used inside ActivityContributorModule
 * With @ContributesAndroidInjector(modules = FragmentContributorModule.class)
 * defines which module will be used to inject objects to declared fragments
 */
@Module
abstract class DetailFragmentContributorModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment
}

