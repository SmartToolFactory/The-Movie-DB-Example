package com.smarttoolfactory.movieapp.constant

object Constants {

    // Rest Api
    const val BASE_URL = "https://api.themoviedb.org/"
    const val API_KEY = "114fe6670282f6a632638661e5e86dee"

    // Image sizes
    const val LARGE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    const val ORIGINAL_IMAGE_URL = "https://image.tmdb.org/t/p/original"
    const val SMALL_IMAGE_URL = "https://image.tmdb.org/t/p/w200"

    // Filter Types
    const val SORT_FILTER = "SORT_FILTER"
    const val SORT_BY_POPULARITY = "popularity.desc"
    const val SORT_BY_TOP_RATED = "vote_average.desc"
    const val SORT_BY_REVENUE = "revenue.desc"

    // Bundle key for passing Movie to details activity

    const val BUNDLE_MOVIE = "BUNDLE_MOVIE"
}