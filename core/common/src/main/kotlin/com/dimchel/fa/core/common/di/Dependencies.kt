package com.dimchel.fa.core.common.di

import android.app.Application


interface Dependencies
interface DependencyStartParams

interface BaseDependencyProvider<D: Dependencies> {
    fun provide(application: Application): D
    fun release()
}

interface BaseDependencyProviderParametrized<D: Dependencies, SP: DependencyStartParams> {
    fun provide(application: Application, startParams: SP): D
    fun release()
}

abstract class BaseDependencyProviderImpl<D: Dependencies> :
    BaseDependencyProvider<D> {

    private var dependencies : D? = null

    protected abstract fun createDependency(application: Application): D

    override fun provide(application: Application): D {
        if (dependencies == null) {
            dependencies = createDependency(application)
        }

        return dependencies!!
    }

    override fun release() {
        dependencies = null
    }
}

abstract class BaseDependencyProviderParametrizedImpl<D: Dependencies, SP: DependencyStartParams> :
    BaseDependencyProviderParametrized<D, SP> {

    private var dependencies : D? = null

    protected abstract fun createDependency(application: Application, startParams: SP): D

    override fun provide(application: Application, startParams: SP): D {
        if (dependencies == null) {
            dependencies = createDependency(application, startParams)
        }

        return dependencies!!
    }

    override fun release() {
        dependencies = null
    }
}