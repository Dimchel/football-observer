package com.dimchel.fa.feature.league.impl.di

import android.app.Application
import com.dimchel.core.data.di.CoreDataDependencyProvider
import com.dimchel.fa.core.common.di.BaseDepsProviderImpl
import com.dimchel.fa.core.network.di.CoreNetworkDependencyProvider
import com.dimchel.fa.feature.league.api.di.LeagueDepsProvider
import com.dimchel.fa.feature.league.api.di.LeagueOutDeps

object LeagueDepsProviderImpl : BaseDepsProviderImpl<LeagueOutDeps>(), LeagueDepsProvider {

    override fun createDependency(application: Application): LeagueOutDeps =
        DaggerLeagueComponent.factory().create(
            application = application,
            coreNetworkDependency = CoreNetworkDependencyProvider.provide(application),
            coreDataDependency = CoreDataDependencyProvider.provide(application),
        )
}