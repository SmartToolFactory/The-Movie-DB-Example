package com.smarttoolfactory.movieapp.di


import com.smarttoolfactory.movieapp.MainActivity
import com.smarttoolfactory.movieapp.moviedetail.MovieDetailActivity


import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

    /**
    Defines which fragments will be used by [MainActivity]
     */
    @ContributesAndroidInjector(modules = [FragmentContributorModule::class])
    abstract fun contributeMainActivity(): MainActivity


    /**
    Defines which fragments will be used by [MovieDetailActivity]
     */
    @ContributesAndroidInjector(modules = [DetailFragmentContributorModule::class])
    abstract fun contributeMainMovieDetailActivity(): MovieDetailActivity
}
