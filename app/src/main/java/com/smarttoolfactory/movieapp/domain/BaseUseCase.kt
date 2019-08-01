package com.smarttoolfactory.movieapp.domain


abstract class BaseUseCase {

    /**
     * This method is required to dispose RxJava Observables
     */
    abstract fun dispose()
}