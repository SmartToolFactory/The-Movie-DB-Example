package com.smarttoolfactory.movieapp.moviedetail

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.smarttoolfactory.movieapp.R
import com.smarttoolfactory.movieapp.constant.Constants
import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.databinding.ActivityMovieDetailBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MovieDetailActivity : DaggerAppCompatActivity() {


    /**
     * ViewModelFactory provides ViewModels from a map that were injected via Map annotation
     */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * ViewModel that contains list of task and queries via Repository or UseCases
     */
    private lateinit var viewModel: MovieDetailViewModel


    private lateinit var dataBinding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieDetailViewModel::class.java)

        // 🔥 This is required if LiveData is used for data-binding
//        dataBinding.lifecycleOwner = this

        val movie = intent.getParcelableExtra<Movie>(Constants.BUNDLE_MOVIE)

        movie.apply {
            viewModel.movie.value = this
        }

        bindViews()
    }

    private fun bindViews() {
        // Set Toolbar
        val toolbar = dataBinding.toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setTitle(R.string.details)

        val fragment = MovieDetailFragment.newInstance(null)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.movie_detail_frame, fragment)
            .commit()

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return true
    }
}