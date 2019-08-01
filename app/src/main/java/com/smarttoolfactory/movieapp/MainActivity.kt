package com.smarttoolfactory.movieapp

import android.os.Bundle
import com.smarttoolfactory.movieapp.data.MoviesRepository
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var repository: MoviesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    println("🔥 MainActivity getMovies() onSuccess() $it")
                }, {
                    println("🎃 MainActivity getMovies() onError(): ${it.message}")
                })
    }


}
