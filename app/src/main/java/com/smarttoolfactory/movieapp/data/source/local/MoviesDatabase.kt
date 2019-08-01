package com.smarttoolfactory.movieapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smarttoolfactory.movieapp.data.model.Movie

/**
 * The Room Database that contains the movies table.
 *
 */
@Database(entities = [Movie::class], version = DATABASE_VERSION, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao
}

const val DATABASE_NAME = "movies.db"
const val DATABASE_VERSION = 1