//package com.smarttoolfactory.movieapp.data.source.local
//
//import androidx.room.Dao
//import com.smarttoolfactory.movieapp.data.model.Movie
//import com.smarttoolfactory.movieapp.data.model.Movies
//import io.reactivex.Flowable
//import io.reactivex.Observable
//
///**
// * Data Access Object for the tasks table.
// */
//@Dao
//interface MoviesDao : BaseDao<Movie> {
//
//    fun getMovies(page: Int): Flowable<List<Movie>>
//
//    fun getMoviesSortedBy( page: Int, sortBy: String): Flowable<List<Movie>>
//
//    fun getMovies(queryMap : Map<String, String>): Flowable<List<Movie>>
//
//}