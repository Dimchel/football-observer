package com.dimchel.core.data.di

import android.app.Application
import com.dimchel.fa.core.common.di.BaseDependencyProviderImpl

object CoreDataDependencyProvider : BaseDependencyProviderImpl<CoreDataDependency>() {

    override fun createDependency(application: Application): CoreDataDependency =
        DaggerCoreDataComponent.factory().create(application)
}