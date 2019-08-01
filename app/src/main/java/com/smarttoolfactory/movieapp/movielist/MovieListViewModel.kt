package com.smarttoolfactory.movieapp.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smarttoolfactory.movieapp.constant.Constants
import com.smarttoolfactory.movieapp.data.MoviesRepository
import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.domain.GetMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject


class MovieListViewModel @Inject
constructor(
    private val repository: MoviesRepository,
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {


    var sortBy = Constants.SORT_BY_POPULAR

    private var page: Int = 1
    private val pagination = BehaviorSubject.create<Int>()


    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var movies = MutableLiveData<List<Movie>>().apply {
        value = emptyList()
    }

    private var paginationList = mutableListOf<Movie>()
    /**
     * Live data that contains movies. This liveData is also used for databinding with list via
     *   app:items=
     */
    val items: LiveData<List<Movie>> = movies

    init {


    }


    fun getMovieList() {

        page++
        pagination.onNext(page)

        pagination.onNext(1)

        val disposable = getMoviesUseCase.getMovies(paginationList, sortBy, pagination)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    println("🥳 MovieListViewModel getMovies() onSuccess() $it")
                    it?.apply {
                        var mv = mutableListOf<Movie>()
                        mv.addAll(movies.value!!)
                        mv.addAll(this)
                        movies.value = mv
                    }
                },
                {
                    println("🥺 MovieListViewModel getMovies() onError() ${it.message}")

                },
                {
                    println("😡 MovieListViewModel getMovies() onComplete")
                }
            )

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}