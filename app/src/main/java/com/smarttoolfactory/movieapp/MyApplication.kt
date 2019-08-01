package com.smarttoolfactory.movieapp

import com.smarttoolfactory.movieapp.di.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication : dagger.android.support.DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        // TODO Fatih, Leakcanary is for testing memory leaks

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
        // Normal app init code...

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}