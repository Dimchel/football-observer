package com.dimchel.fa.core.common.di

import android.app.Application

abstract class BaseDependencyProviderImpl<T> : BaseDependencyProvider<T> {

    private var dependencies : T? = null

    protected abstract fun createDependency(application: Application): T

    override fun provide(application: Application): T {
        if (dependencies == null) {
            dependencies = createDependency(application)
        }

        return dependencies!!
    }

    override fun release() {
        dependencies = null
    }
}