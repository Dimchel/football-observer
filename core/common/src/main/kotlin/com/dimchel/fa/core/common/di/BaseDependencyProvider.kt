package com.dimchel.fa.core.common.di

import android.app.Application

interface BaseDependencyProvider<T> {
    fun provide(application: Application): T
    fun release()
}