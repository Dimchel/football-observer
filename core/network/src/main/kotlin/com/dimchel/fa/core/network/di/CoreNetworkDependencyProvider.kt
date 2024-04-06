package com.dimchel.fa.core.network.di

import android.app.Application
import com.dimchel.fa.core.common.di.BaseDepsProviderImpl

object CoreNetworkDependencyProvider : BaseDepsProviderImpl<CoreNetworkDependency>() {

    override fun createDependency(application: Application): CoreNetworkDependency =
        DaggerCoreNetworkComponent.factory().create(application)
}