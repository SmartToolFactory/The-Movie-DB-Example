package com.smarttoolfactory.movieapp.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smarttoolfactory.movieapp.data.model.Movie
import com.smarttoolfactory.movieapp.databinding.MovieItemBinding
import com.smarttoolfactory.movieapp.movielist.MovieListViewModel

/**
 * Adapter for the movie list. Has a reference to the [MovieListViewModel] to send actions back to it.
 */
class MovieListAdapter(private val viewModel: MovieListViewModel) :
    ListAdapter<Movie, MovieListAdapter.CustomViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        println("🎃🎃 MoviesAdapter onCreateViewHolder() viewType: $viewType")
        return CustomViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = getItem(position)
//        println("🔥🔥 MoviesAdapter onBindViewHolder() position: $position, holder: $holder")
        holder.bind(viewModel, item)
    }

    override fun onViewRecycled(holder: CustomViewHolder) {
        super.onViewRecycled(holder)
//        println("🥶🥶 MoviesAdapter onViewRecycled() holder $holder")
    }


    class CustomViewHolder private constructor(val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: MovieListViewModel, item: Movie) {

            binding.viewmodel = viewModel
            binding.movie = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CustomViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieItemBinding.inflate(layoutInflater, parent, false)

                return CustomViewHolder(binding)
            }
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class TaskDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}
