package ru.today.news

import android.app.Application
import android.content.res.Resources
import ru.today.news.injection.components.AppComponent
import timber.log.Timber

class NewsApp : Application() {

    companion object {

        lateinit var instance: NewsApp
            private set

        lateinit var appComponent: AppComponent
            private set

        val res: Resources
            get() = instance.resources
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        instance = this
    }
}