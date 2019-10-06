package com.smarttoolfactory.movieapp

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.smarttoolfactory.movieapp.constant.Constants
import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.databinding.ActivityMainBinding
import com.smarttoolfactory.movieapp.moviedetail.MovieDetailActivity
import com.smarttoolfactory.movieapp.moviedetail.MovieDetailFragment
import com.smarttoolfactory.movieapp.movielist.MovieListFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {


    /**
     * ViewModelFactory provides ViewModels from a map that were injected via Map annotation
     */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * ViewModel that contains list of task and queries via Repository or UseCases
     *
     * 🔥 TODO This ViewModel does not work now since each fragment has it's own ViewModel to fill their own lists
     */
//    private lateinit var viewModel: MovieListViewModel


    private lateinit var dataBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieListViewModel::class.java)

        // 🔥 This is required if LiveData is used for data-binding
        dataBinding.lifecycleOwner = this

        bindViews()


    }

    /**
     * Set toolbar and fragments that contain movie lists
     */
    private fun bindViews() {

        // Set Toolbar
        val toolbar = dataBinding.toolbar
        setSupportActionBar(toolbar)

        setTitle(R.string.catalog)

        val fragment = MovieListFragment.newInstance(Constants.SORT_BY_POPULARITY)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_frame1, fragment)
            .commit()


        val fragment2 = MovieListFragment.newInstance(Constants.SORT_BY_TOP_RATED)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_frame2, fragment2)
            .commit()

        val fragment3 = MovieListFragment.newInstance(Constants.SORT_BY_REVENUE)
        supportFragmentManager
            .beginTransaction()
//                    .addToBackStack(null)
            .replace(R.id.content_frame3, fragment3)
            .commit()
    }


    /**
     * Display movie details as list fragment for tablets or landscape orientation or open movie details
     */
    fun displayMovieDetails(movie: Movie) {


        val isMultiPane = (findViewById<View>(R.id.content_frame_details) != null)


        Toast.makeText(
            this,
            "MainActivity displayMovieDetails() isMultiPane: $isMultiPane",
            Toast.LENGTH_SHORT
        ).show()

        if (isMultiPane) {

            val fragment = MovieDetailFragment.newInstance(movie)

            supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.content_frame_details, fragment)
                .commit()

        } else {

            val bundle = bundleOf("Hello" to "hello_key")

            val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
            intent.putExtra(Constants.BUNDLE_MOVIE, movie)
            startActivity(intent)

        }


    }


}
