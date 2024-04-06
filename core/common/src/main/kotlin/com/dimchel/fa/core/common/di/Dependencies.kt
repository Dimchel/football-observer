package com.dimchel.fa.core.common.di

import android.app.Application


interface OutDeps
interface InDeps

interface DepsProvider<D: OutDeps> {
    fun provide(application: Application): D
    fun release()
}

interface DepsProviderParametrized<D: OutDeps, SP: InDeps> {
    fun provide(application: Application, startParams: SP): D
    fun release()
}

abstract class BaseDepsProviderImpl<D: OutDeps> :
    DepsProvider<D> {

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

abstract class BaseDepsProviderParametrizedImpl<D: OutDeps, SP: InDeps> :
    DepsProviderParametrized<D, SP> {

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