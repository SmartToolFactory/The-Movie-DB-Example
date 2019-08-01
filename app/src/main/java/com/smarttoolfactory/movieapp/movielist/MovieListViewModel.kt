package com.smarttoolfactory.movieapp.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smarttoolfactory.movieapp.constant.Constants
import com.smarttoolfactory.movieapp.data.MoviesRepository
import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.domain.GetMoviesUseCase
import com.smarttoolfactory.movieapp.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MovieListViewModel @Inject
constructor(
    private val repository: MoviesRepository,
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    var sortBy = Constants.SORT_BY_POPULARITY

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var movies = MutableLiveData<List<Movie>>().apply {
        value = emptyList()
    }

    /**
     * Live data that contains movies. This liveData is also used for databinding with list via
     *   app:items=
     */
    val items: LiveData<List<Movie>> = movies

    /**
     * SingleLiveEvent for opening movie details via databinding.
     *
     * ⚠️ This method is called by movie_item of any RecyclerView adapter
     */

    val openMovieDetailsEvent = SingleLiveEvent<Movie>()


    val testData = MutableLiveData<Boolean>()

    /**
     * Gets movies list from [GetMoviesUseCase]
     */
    fun getMovieList() {

        val disposable = getMoviesUseCase.getMovies(sortBy)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    println("🥳 MovieListViewModel getMovies() onSuccess() $it")
                    movies.value = it
                },
                {
                    println("🥺 MovieListViewModel getMovies() onError() ${it.message}")

                },
                {
                    println("😡 MovieListViewModel getMovies() onComplete")
                }
            )

        compositeDisposable.add(disposable)

    }

    /**
     * Opens detail activity or detail fragment depending on device or orientation
     */
    fun openMovieDetails(movie: Movie) {
        openMovieDetailsEvent.value = movie
        testData.value = true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        getMoviesUseCase.dispose()
    }
}