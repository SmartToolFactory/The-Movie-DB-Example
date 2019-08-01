package com.smarttoolfactory.movieapp.moviedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smarttoolfactory.movieapp.data.model.Movie
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor() : ViewModel() {

    var movie = MutableLiveData<Movie>()

    init {

    }
}