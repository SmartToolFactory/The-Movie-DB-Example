package com.smarttoolfactory.movieapp

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.smarttoolfactory.movieapp.constant.Constants
import com.smarttoolfactory.movieapp.data.MoviesRepository
import com.smarttoolfactory.movieapp.databinding.ActivityMainBinding
import com.smarttoolfactory.movieapp.movielist.MovieListFragment
import com.smarttoolfactory.movieapp.movielist.MovieListViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var repository : MoviesRepository


    /**
     * ViewModelFactory provides ViewModels from a map that were injected via Map annotation
     */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * ViewModel that contains list of task and queries via Repository or UseCases
     */
    private lateinit var viewModel: MovieListViewModel


    private lateinit var dataBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieListViewModel::class.java)

        // 🔥 This is required if LiveData is used for data-binding
//        dataBinding.lifecycleOwner = this

        bindViews()

    }

    private fun bindViews() {

        // Set Toolbar
        val toolbar = dataBinding.toolbar
        setSupportActionBar(toolbar)

        val fragment = MovieListFragment.newInstance(Constants.SORT_BY_POPULAR)
        supportFragmentManager
            .beginTransaction()
//                    .addToBackStack(null)
            .replace(R.id.content_frame, fragment)
            .commit()


        val fragment2 = MovieListFragment.newInstance(Constants.SORT_BY_TOP_RATED)
        supportFragmentManager
            .beginTransaction()
//                    .addToBackStack(null)
            .replace(R.id.content_frame2, fragment2)
            .commit()

        val fragment3 = MovieListFragment.newInstance(Constants.SORT_BY_REVENUE)
        supportFragmentManager
            .beginTransaction()
//                    .addToBackStack(null)
            .replace(R.id.content_frame3, fragment3)
            .commit()
    }

}
