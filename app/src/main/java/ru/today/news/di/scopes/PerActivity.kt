package ru.today.news.di.scopes

import javax.inject.Scope

/**
 * Область видимости - Activity
 *
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity