package com.smarttoolfactory.movieapp.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.smarttoolfactory.movieapp.constant.Constants
import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.databinding.FragmentMovieDetailBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject


/**
 * This fragment is responsible of displaying movie details, data of every view is set via data-binding, imageview is set with binding adapter
 */
class MovieDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MovieDetailViewModel

    private lateinit var dataBinding: FragmentMovieDetailBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val movieFromArguments: Movie? = arguments?.getParcelable(Constants.BUNDLE_MOVIE)

        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(MovieDetailViewModel::class.java)

        dataBinding = DataBindingUtil.inflate(
            inflater, com.smarttoolfactory.movieapp.R.layout.fragment_movie_detail, container, false
        )

        // 🔥 This is required if LiveData is used for data-binding, This fragment is using ViewModel for to set app:Items property of RecyclerView
        dataBinding.lifecycleOwner = this

        // Set movie of data-binding to apply ui changes on screen, first one is for multi-pane, sec
        dataBinding.movie = movieFromArguments ?: viewModel.movie.value

        return dataBinding.root
    }


    /**
     * Create new instance of fragment with arguments. This method is needed for multi-pane behavior since there is no [MovieDetailActivity]
     * to provide [Movie] to [MovieDetailFragment]
     */
    companion object {

        fun newInstance(movie: Movie?): MovieDetailFragment {

            val args = Bundle()
            movie?.apply {
                args.putParcelable(Constants.BUNDLE_MOVIE, movie)
            }
            val fragment = MovieDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

}