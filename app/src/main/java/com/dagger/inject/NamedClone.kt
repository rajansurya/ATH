package com.dagger.inject

import javax.inject.Qualifier

/**
 * Created by Rajan on 13-04-2019.
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class NamedClone(val type:TrackerType)

enum class TrackerType {
    POST,
    GET
}

