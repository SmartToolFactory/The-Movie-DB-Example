package com.smarttoolfactory.movieapp.base

import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment


/**
 * BaseFragment to avoid writing data-binding code over again for each fragment
 */
abstract class BaseFragment<T : ViewDataBinding> : DaggerFragment() {

    protected var dataBinding: T? = null

    /**
     * Point that contains width and height of the fragment.
     *
     *
     * Dimensions are required for getting projection to get coordinates of each side of the fragment
     *
     */
    private val dimensions = Point()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        println("BaseFragment onCreateView()")

        // Each fragment can have it's seprate toolbar menu
        setHasOptionsMenu(true)

        dataBinding =
            DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false)

        val rootView = dataBinding?.root

        // Get width and height of the fragment
        rootView?.post {
            dimensions.x = rootView.width
            dimensions.y = rootView.height

//            println("onCreateView() -> post() width: " + dimensions.x + ", height: " + dimensions.y)
        }

        return rootView
    }

    /**
     * This method gets the layout id from the derived fragment to bind to that layout via data-binding
     */
    abstract fun getLayoutId(): Int

}