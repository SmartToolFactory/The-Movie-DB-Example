package com.smarttoolfactory.movieapp.base


abstract class BaseUseCase {

    /**
     * This method is required to dispose RxJava Observables
     */
    abstract fun dispose()
}