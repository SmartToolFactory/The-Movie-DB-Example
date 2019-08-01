package com.smarttoolfactory.movieapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smarttoolfactory.movieapp.R
import com.smarttoolfactory.movieapp.constant.Constants
import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.movielist.adapter.MovieListAdapter

/*
    *** Bindings for List ***
 */
/**
 * [BindingAdapter]s for the [Movie]s to ListAdapter.
 */
@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Movie>) {
    println("🔥 MovieListBindings $items")
    (listView?.adapter as MovieListAdapter)?.submitList(items)
}


/**
 * Binding adapter used with this class android:src used with binding of this object
 * loads image from url into specified view
 *
 * @param view image to be loaded into
 * @param url  of the image to be fetched
 */
@BindingAdapter("android:url")
fun setImageUrl(view: ImageView, url: String?) {

    try {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_image_placeholder_darker)
        requestOptions.error(R.drawable.ic_image_placeholder_grey)

        val urlFinal = Constants.SMALL_IMAGE_URL + url

        Glide.with(view.context)
            .setDefaultRequestOptions(requestOptions)
            .load(urlFinal)
            .into(view)
    } catch (e: Exception) {
        print("🥶🥶 MovieListBindings setImageUrl() exception ${e.message}")
    }
}

@BindingAdapter("android:urlOriginal")
fun setImageUrlOriginal(view: ImageView, url: String?) {

    try {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_image_placeholder_darker)
        requestOptions.error(R.drawable.ic_image_placeholder_grey)

        val urlFinal = Constants.ORIGINAL_IMAGE_URL + url

        Glide.with(view.context)
            .setDefaultRequestOptions(requestOptions)
            .load(urlFinal)
            .into(view)
    } catch (e: Exception) {
        print("🥶🥶 MovieListBindings setImageUrl() exception ${e.message}")
    }
}