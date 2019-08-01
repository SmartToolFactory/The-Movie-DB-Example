package com.smarttoolfactory.movieapp.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarttoolfactory.movieapp.constant.Constants
import com.smarttoolfactory.movieapp.databinding.FragmentMovieListBinding
import com.smarttoolfactory.movieapp.movielist.adapter.MovieListAdapter
import com.smarttoolfactory.movieapp.utils.EndlessScrollListener
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class MovieListFragment : DaggerFragment(), EndlessScrollListener.ScrollToBottomListener {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MovieListViewModel

    private lateinit var dataBinding: FragmentMovieListBinding

    /**
     * Listener for listening scrolling to last item of Recyclerview
     */
    private lateinit var endlessScrollListener: EndlessScrollListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieListViewModel::class.java)


        arguments?.apply {
            var sortBy =getString(Constants.SORT_FILTER)

            println("MovieListFragment onCreate() sortBy: $sortBy, this: $this")
            viewModel.sortBy = getString(Constants.SORT_FILTER)
        }

        dataBinding = DataBindingUtil.inflate(
            inflater, com.smarttoolfactory.movieapp.R.layout.fragment_movie_list, container, false
        )

        dataBinding.viewmodel = viewModel

        // 🔥 This is required if LiveData is used for data-binding
        dataBinding.lifecycleOwner = this

        // Set RecyclerView layout manager, adapter, and scroll listener for infinite scrolling
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        endlessScrollListener = EndlessScrollListener(linearLayoutManager, this)

        dataBinding.recyclerView.apply {
            this.layoutManager = linearLayoutManager
            this.addOnScrollListener(endlessScrollListener)
            this.adapter = MovieListAdapter(viewModel)
        }

        return dataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovieList()
    }

    override fun onScrollToBottom() {
        Toast.makeText(activity, "Scrolled end of the list", Toast.LENGTH_SHORT).show()
        viewModel.getMovieList()

    }

    /**
     * Create new instance of fragment with arguments
     */
    companion object {

        fun newInstance(sortBy: String): MovieListFragment {

            val args = Bundle()
            args.putString(Constants.SORT_FILTER, sortBy)
            val fragment = MovieListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
